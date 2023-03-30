package day9.hw;

interface Rentable{
    void rent();  // 추상 메서드 (제어자는 생략해도 public abstract가 자동으로 붙음)
}

// 항상 사용되는 애를 먼저 만들기 때문에 TV를 먼저 만들기
class TV{
    private String model;
    private int size;
    private int channel;
    public TV(){}  // 메서드 블록 끝에 세미콜론 붙이지 말자.
    public TV(String model, int size, int channel){
        this.model = model;
        this.size = size;
        this.channel = channel;
    }

    public void channelUp(){
        channel++;  // 11이 되는 순간 밑의 if블록으로 들어가서 실행
        if(channel>10){
            channel=1;
        }
//        channel++; // 얘가 if 블록보다 먼저 나와야 함
    };

    public void channelDown(){
        channel--;   // 연산 수행 후 1보다 작아지면 if블록으로 들어감  (먼저 조정 하고나서 요구사항대로 세팅)
        if(channel<1){
            channel=10;
        }
//        channel--;  // 얘가 if블록보다 먼저 나와야 함
    };

    /* getter & setter */
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }
}

class SaleTV extends TV{
    private int price;

    /* 생성자 */
    public SaleTV(){}  // 블록 끝에 세미콜론 붙이지 말자.
    public SaleTV(int price, String model, int size, int channel){
        super(model,size,channel);
        this.price = price;
    }

    /* 일반변수 */
    public void play(){
        // 채널 정보는 부모의 getter 메서드를 호출해서 처리
        System.out.printf("판매 TV 채널의 %d번 프로를 플레이합니다.\n",getChannel());
    };

    public void sale(){
        System.out.printf("%s 모델의 상품을 판매합니다. %,d원을 지불해주세요.\n",getModel(),price);
    };

    /* Object 클래스의 toString을 오버라이딩 */
    public String toString(){
        // price는 이 클래스 내부의 멤버변수이므로 그대로 사용해도 됨
        // get모델 , get프라이스는 조상의 멤버변수이므로 getter 메서드를 호출해서 사용
        return String.format("판매상품정보 : 모델명(%s), 가격(%,d원), 크기(%d)",getModel(),price,getSize());
    };

    /* getter & setter */
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}

class RentalTV extends TV implements Rentable{
    private int price;

    /* 생성자 */
    public RentalTV(){};
    public RentalTV(int price, String model, int size, int channel){
        super(model, size, channel);
        this.price = price;
    }

    public void play(){
        System.out.printf("대여 TV 채널의 %d번 프로를 플레이합니다.\n",getChannel());
    };
    public void rent(){
        System.out.printf("%s 모델의 상품을 대여합니다. %,d원을 지불해주세요.\n",getModel(),price);
    };
    public String toString(){
        return String.format("대여상품정보 : 모델명(%s), 가격(%,d원), 크기(%d)",getModel(),price,getSize());
    };


    /* getter & setter */
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}


public class TVTest {
    public static void main(String[] args) {
        /* 객체 생성 */
        SaleTV saletv = new SaleTV(300000,"SALETV-1",40,1);
        RentalTV rentaltv = new RentalTV(100000,"RENTALTV-10",42,1);

        for (int i=0; i<2; i++){
            saletv.channelUp();
            rentaltv.channelDown();
        }
        rentaltv.channelDown();

        // 객체를 전달해서 메서드 호출
        printAll(saletv);
        printAll(rentaltv);

        // 매개변수 타입이 Rentable -> saletv는 Reantable의 자손이 아니므로 전달 불가
        printRentalTV(rentaltv);
    }

    static void printAll(TV tv){
        System.out.println(tv);  // tv와 tv.toString()는 출력 결과가 동일
//        System.out.println(tv.toString());  // tv가 상속하는 Object의 toString 이용 (toString 생략해도 자동으로 참조하게된 객체의 toString 메서드 수행결과가 호출됨)
        if(tv instanceof RentalTV){  // 실제 참조하는 객체가 RentalTV인지 확인. (참조하게 된 객체의 가장 하위영역의 객체부터 찾아감)
            ((RentalTV) tv).play();  // 형변환해서 호출
        } else if (tv instanceof SaleTV){  // tv의 자손이 뭐가 더 있는지 모르므로 else문 대신 else if 사용
            ((SaleTV) tv).play();
            ((SaleTV) tv).sale();
        }
        // if-else if 문이 아닌 if문 2개 적어주면 비교가 2번씩 수행됨. -> 메모리 낭비
//        if (tv instanceof SaleTV){
//            ((SaleTV) tv).play();
//            ((SaleTV) tv).sale();
//        }
    }

    static void printRentalTV(Rentable tv){
        tv.rent();
    }
}
