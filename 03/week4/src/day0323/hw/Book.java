package day0323.hw;

public class Book {
    String title;
    String author;
    int price;

    Book(){
        title = "이것이 자바다";
        author = "신용권";
        price = 32400;
    }

    Book(String title, String author, int price){
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getBookInfo(){
//        String result = "";
//        result += ("제목: " + title + " / 저자: " + author + " / 가격: " + price);
//        return result;
        return String.format("제목 : %-15s  저자 : %-10s  가격 : %-10d",title,author,getPrice());
    }
}
