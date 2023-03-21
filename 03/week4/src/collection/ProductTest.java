package collection;

import java.util.HashSet;
import java.util.Objects;

class Product{
    /* 멤버변수 */
    private String productID;
    private String productName;
    private String productPrice;

    /* 생성자 메서드 */
    Product(String productID, String productName, String productPrice){
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public boolean equals(Object obj){
        boolean result = false;
        if(obj != null && obj instanceof Product){
            if(productID == ((Product) obj).productID){
                result = true;
            }
        }
        return result;
    }

    /* toString 오버라이딩 */
    @Override
    public String toString(){
        return productID + "\t" + productName + "\t" + productPrice;
    }

    /* hashCode 오버라이딩 */

    @Override
    public int hashCode() {
        return Objects.hash(productID);
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Product p1 = new Product("p100","TV","        20000");
        Product p2 = new Product("p200","Computer","10000");
        Product p3 = new Product("p100","MP3","700");
        Product p4 = new Product("p300","Audio","    1000");

        HashSet<Product> set = new HashSet<>();

        if(set.contains(p1)){
            System.out.println("동일한 ID의 제품이 이미 저장되어 있습니다");
        } else {
            set.add(p1);
            System.out.println("성공적으로 저장되었습니다.");
        }

        if(set.contains(p2)){
            System.out.println("동일한 ID의 제품이 이미 저장되어 있습니다");
        } else {
            set.add(p2);
            System.out.println("성공적으로 저장되었습니다.");
        }

        if(set.contains(p3)){
            System.out.println("동일한 ID의 제품이 이미 저장되어 있습니다");
        } else {
            set.add(p3);
            System.out.println("성공적으로 저장되었습니다.");
        }

        if(set.contains(p4)){
            System.out.println("동일한 ID의 제품이 이미 저장되어 있습니다");
        } else {
            set.add(p4);
            System.out.println("성공적으로 저장되었습니다.");
        }

        System.out.println();

        System.out.println("제품ID\t제품명\t\t가격");
        System.out.println("--------------------------------------------------");
        for (Product data: set){
            System.out.println(data);
        }

    }
}
