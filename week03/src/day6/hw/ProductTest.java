package day6.hw;
// 상품정보를 배열에 담을 것

class Product{
    String name;
    int balance;
    int price;

    Product(){
        name = "듀크인형";
        balance = 5;
        price = 10000;
    }

    Product(String name, int balance, int price){
        this.name = name;
        this.balance = balance;
        this.price = price;
    }

    String getName(){
        return name;
    }

    int getBalance(){
        return balance;
    }

    int getPrice(){
        return price;
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Product[] prod = new Product[5];
        prod[0] = new Product("하나인형",10, 10000000);
        prod[1] = new Product("두리인형",15, 15000);
        prod[2] = new Product("세찌인형",20, 20000);
        prod[3] = new Product("네찌인형",30, 30000);
        prod[4] = new Product();

        for (Product el: prod){
            System.out.printf("상품명: %s / 재고량: %d / 가격: %,d원\n",el.getName(), el.getBalance(), el.getPrice());
        }
    }
}
