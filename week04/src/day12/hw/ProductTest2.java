package day12.hw;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;

class Product2 implements Comparable<Product2>{
    // 비교 가능한 객체로 만들기 위해 Comparable 상속 (상속하지 않으면 Collection.sort()를 사용할 수 없음)
    // productPrice를 기준으로 객체의 대소 관계를 비교할 수 있는 객체가 되도록 구현할 것

    /* 멤버변수 - 대문자로 시작하면 안됨 */
    private String productID;
    private String productName;
    private String productPrice;

    /* 생성자 메서드 */
    Product2(){}

    Product2(String productID, String productName, String productPrice){
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public boolean equals(Object obj){
        boolean result = false;
        if(obj != null && obj instanceof Product2){
            if(productID == ((Product2) obj).productID){
                result = true;
            }
        }
        return result;
    }

    /* hashCode 오버라이딩 */
    @Override
    public int hashCode() {
        return Objects.hash(productID);
    }



    @Override
    public int compareTo(Product2 o) {
        /* Product 객체는 가격으로 비교 */
        // 기준 객체와 타겟 객체(o.productPrice)를 비교
        if(Integer.parseInt(productPrice) < Integer.parseInt(o.productPrice)){
            return 1;
        } else if (productPrice == o.productPrice){
            return 0;
        } else {
            return -1;
        }
    }

    /* toString 오버라이딩 */
    @Override
    public String toString(){
        return String.format("%-7s %-11s %,d원",productID,productName, Integer.parseInt(productPrice));
    }
}

public class ProductTest2 {
    public static void main(String[] args) {
        LinkedList<Product2> ll = new LinkedList<>();
        ll.add(new Product2("p100","TV","20000"));
        ll.add(new Product2("p200","Computer","10000"));
        ll.add(new Product2("p100","MP3","700"));
        ll.add(new Product2("p300","Audio","1000"));

        Collections.sort(ll);

        System.out.println("제품ID\t제품명\t\t가격");
        System.out.println("------------------------------");
        for (Product2 el: ll) {
            System.out.println(el);
        }
    }
}