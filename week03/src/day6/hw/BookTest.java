package day6.hw;

class Book{
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


    String getBookInfo(){
        String result = "";
        result += ("책이름: " + title + " / 저자: " + author + " / 가격: " + price);
        return result;
    }
}

public class BookTest {
    public static void main(String[] args) {
        /* 객체 생성 */
        Book bk1 = new Book("C언어로 쉽게 풀어쓴 자료구조", "천인국", 29000);
        Book bk2 = new Book("혼자 공부하는 파이썬", "윤인성", 19800);
        Book bk3 = new Book("데이터베이스 개론", "김연희", 29000);
        Book bk4 = new Book("인공지능 시대의 컴퓨터 개론", "김대수", 28000);
        Book bk5 = new Book();

        System.out.println(bk1.getBookInfo());
        System.out.println(bk2.getBookInfo());
        System.out.println(bk3.getBookInfo());
        System.out.println(bk4.getBookInfo());
        System.out.println(bk5.getBookInfo());
    }
}
