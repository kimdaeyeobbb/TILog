
# 과제
```java
package emp;

// 사용하는애보다 사용되는 애를 먼저 기재하자.
// Bonus를 Sales와 Secretary보다 늦게 입력시 계속 에러표시가 뜸.

interface Bonus{
    void incentive(int pay);
}

abstract class Employee{
    private String name;
    private int number;
    private String department;
    private int salary;


    /* setter & getter */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee(){};
    public Employee(String name, int number, String department, int salary){
        this.name = name;
        this.number = number;
        this.department = department;
        this.salary = salary;
    }

    /* 추상 메서드 */
    public abstract double tax();
}

class Secretary extends Employee implements Bonus{
    public Secretary(){};
    public Secretary(String name, int number, String department, int salary){
        super(name,number,department,salary);
    }
    public double tax(){
        return getSalary()*0.1;
    }

    public void incentive(int pay){
        setSalary(getSalary()+(int)(pay*0.8));
    }
}

class Sales extends Employee implements Bonus{
    public Sales(){};
    public Sales(String name, int number, String department, int salary){
        super(name, number, department, salary);
    };
    public double tax(){
        return getSalary()*0.13;
    }
    public void incentive(int pay){
        setSalary(getSalary()+(int)(pay*1.2));
    };

    public double getExtraPay(){
        return getSalary()*0.03;
    }
}

public class Company {
    public static void main(String[] args) {
        Employee emp[] = new Employee[2];
        emp[0] = new Secretary("Duke", 1, "secretary",800);
        emp[1] = new Sales("Tuxi", 2, "sales",1200);

        printEmployee(emp,true);

        System.out.println("\n[인센티브 100 지급]");
        ((Bonus)emp[0]).incentive(100);
        ((Bonus)emp[1]).incentive(100);
        printEmployee(emp,false);
    }

    public static void printEmployee(Employee[] emp, boolean isTax){
        if(!(isTax)){
            System.out.println("name \t department \t salary \t tax \t extra pay");
            System.out.println("-------------------------------------------------------");

            for (Employee el: emp) {
                if (el.getDepartment().equals("sales")) {
                    System.out.printf("%s \t %s \t\t\t %d \t\t %.1f \t %.1f\n", el.getName(), el.getDepartment(), el.getSalary(), el.tax(), ((Sales) el).getExtraPay());
                } else {
                    System.out.printf("%s \t %s \t\t %d \t\t %.1f \t \n", el.getName(), el.getDepartment(), el.getSalary(), el.tax());
                }
            }
            System.out.println();

        } else {
            System.out.println("name \t department \t salary \t extra pay");
            System.out.println("------------------------------------------------");
            for (Employee el: emp) {
                if (el.getDepartment().equals("sales")) {
                    System.out.printf("%s \t %s \t\t\t %d \t\t %.1f\n", el.getName(), el.getDepartment(), el.getSalary(), ((Sales) el).getExtraPay());
                } else {
                    System.out.printf("%s \t %s \t\t %d \t \n", el.getName(), el.getDepartment(), el.getSalary());
                }
            }
            System.out.println();
        }
    }
}

```

- emp은 Employee의 자식 객체
    - 부모객체의 이름으로도 불릴 수 있음 (우리도 어디가서 부모를 대신함)

- .equals 대신 instanceof 연산자를 사용할 것
    - `el instanceof Sales` 로 수정하기

- 개선한 코드
```java
package emp;

// 사용하는애보다 사용되는 애를 먼저 기재하자.
// Bonus를 Sales와 Secretary보다 늦게 입력시 계속 에러표시가 뜸.

interface Bonus{
    void incentive(int pay);
}

abstract class Employee{
    private String name;
    private int number;
    private String department;
    private int salary;


    /* setter & getter */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee(){};
    public Employee(String name, int number, String department, int salary){
        this.name = name;
        this.number = number;
        this.department = department;
        this.salary = salary;
    }

    /* 추상 메서드 */
    public abstract double tax();
}

class Secretary extends Employee implements Bonus{
    public Secretary(){};
    public Secretary(String name, int number, String department, int salary){
        super(name,number,department,salary);
    }
    public double tax(){
        return getSalary()*0.1;
    }

    public void incentive(int pay){
        setSalary(getSalary()+(int)(pay*0.8));
    }
}

class Sales extends Employee implements Bonus{
    public Sales(){};
    public Sales(String name, int number, String department, int salary){
        super(name, number, department, salary);
    };
    public double tax(){
        return getSalary()*0.13;
    }
    public void incentive(int pay){
        setSalary(getSalary()+(int)(pay*1.2));
    };

    public double getExtraPay(){
        return getSalary()*0.03;
    }
}

public class Company {
    public static void main(String[] args) {
        Employee emp[] = new Employee[2];
        emp[0] = new Secretary("Duke", 1, "secretary",800);
        emp[1] = new Sales("Tuxi", 2, "sales",1200);

        printEmployee(emp,true);

        System.out.println("\n[인센티브 100 지급]");
        ((Bonus)emp[0]).incentive(100);
        ((Bonus)emp[1]).incentive(100);
        printEmployee(emp,false);
    }

    public static void printEmployee(Employee[] emp, boolean isTax){
        if(!(isTax)){
            System.out.println("name \t department \t salary \t tax \t extra pay");
            System.out.println("-------------------------------------------------------");

            for (Employee el: emp) {
                if (el instanceof Sales) {
                    System.out.printf("%s \t %s \t\t\t %d \t\t %.1f \t %.1f\n", el.getName(), el.getDepartment(), el.getSalary(), el.tax(), ((Sales) el).getExtraPay());
                } else {
                    System.out.printf("%s \t %s \t\t %d \t\t %.1f \t \n", el.getName(), el.getDepartment(), el.getSalary(), el.tax());
                }
            }
            System.out.println();

        } else {
            System.out.println("name \t department \t salary \t extra pay");
            System.out.println("------------------------------------------------");
            for (Employee el: emp) {
                if (el instanceof Sales) {
                    System.out.printf("%s \t %s \t\t\t %d \t\t %.1f\n", el.getName(), el.getDepartment(), el.getSalary(), ((Sales) el).getExtraPay());
                } else {
                    System.out.printf("%s \t %s \t\t %d \t \n", el.getName(), el.getDepartment(), el.getSalary());
                }
            }
            System.out.println();
        }
    }
}

```

- incentive
    - 보너스를 추가 상속하면서 구현함

- Bonus형으로 형변환
    - `((Bonus) emp[0]).incentive(100)`

- getExtraPay
    - sales만 단독으로 추가하고 있음
    - 따라서 Sales 형으로 바꾸어야 사용이 가능함

# 실습2

## getter & setter
- 멤버변수 > 생성자 > 일반변수 순으로 작성 getter & setter는 일반변수임

```java
package day9.hw;

interface Rentable {
    void rent();  // 추상 메서드 (제어자는 생략해도 public abstract가 자동으로 붙음)
}

// 항상 사용되는 애를 먼저 만들기 때문에 TV를 먼저 만들기
class TV {
    private String model;
    private int size;
    private int channel;

    public TV() {
    }  // 메서드 블록 끝에 세미콜론 붙이지 말자.

    public TV(String model, int size, int channel) {
        this.model = model;
        this.size = size;
        this.channel = channel;
    }

    public void channelUp() {
        channel++;  // 11이 되는 순간 밑의 if블록으로 들어가서 실행
        if (channel > 10) {
            channel = 1;
        }
//        channel++; // 얘가 if 블록보다 먼저 나와야 함
    }

    ;

    public void channelDown() {
        channel--;   // 연산 수행 후 1보다 작아지면 if블록으로 들어감  (먼저 조정 하고나서 요구사항대로 세팅)
        if (channel < 1) {
            channel = 10;
        }
//        channel--;  // 얘가 if블록보다 먼저 나와야 함
    }

    ;

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

class SaleTV extends TV {
    private int price;

    /* 생성자 */
    public SaleTV() {
    }  // 블록 끝에 세미콜론 붙이지 말자.

    public SaleTV(int price, String model, int size, int channel) {
        super(model, size, channel);
        this.price = price;
    }

    /* 일반변수 */
    public void play() {
        // 채널 정보는 부모의 getter 메서드를 호출해서 처리
        System.out.printf("판매 TV 채널의 %d번 프로를 플레이합니다.\n", getChannel());
    }

    ;

    public void sale() {
        System.out.printf("%s 모델의 상품을 판매합니다. %,d원을 지불해주세요.\n", getModel(), price);
    }

    ;

    /* Object 클래스의 toString을 오버라이딩 */
    public String toString() {
        // price는 이 클래스 내부의 멤버변수이므로 그대로 사용해도 됨
        // get모델 , get프라이스는 조상의 멤버변수이므로 getter 메서드를 호출해서 사용
        return String.format("판매상품정보 : 모델명(%s), 가격(%,d원), 크기(%d)", getModel(), price, getSize());
    }

    ;

    /* getter & setter */
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}

class RentalTV extends TV implements Rentable {
    private int price;

    /* 생성자 */
    public RentalTV() {
    }

    ;

    public RentalTV(int price, String model, int size, int channel) {
        super(model, size, channel);
        this.price = price;
    }

    public void play() {
        System.out.printf("대여 TV 채널의 %d번 프로를 플레이합니다.\n", getChannel());
    }

    ;

    public void rent() {
        System.out.printf("%s 모델의 상품을 대여합니다. %,d원을 지불해주세요.\n", getModel(), price);
    }

    ;

    public String toString() {
        return String.format("대여상품정보 : 모델명(%s), 가격(%,d원), 크기(%d)", getModel(), price, getSize());
    }

    ;


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
        SaleTV saletv = new SaleTV(300000, "SALETV-1", 40, 1);
        RentalTV rentaltv = new RentalTV(100000, "RENTALTV-10", 42, 1);

        for (int i = 0; i < 2; i++) {
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

    static void printAll(TV tv) {
        System.out.println(tv);  // tv와 tv.toString()는 출력 결과가 동일
//        System.out.println(tv.toString());  // tv가 상속하는 Object의 toString 이용 (toString 생략해도 자동으로 참조하게된 객체의 toString 메서드 수행결과가 호출됨)
        if (tv instanceof RentalTV) {  // 실제 참조하는 객체가 RentalTV인지 확인. (참조하게 된 객체의 가장 하위영역의 객체부터 찾아감)
            ((RentalTV) tv).play();  // 형변환해서 호출
        } else if (tv instanceof SaleTV) {  // tv의 자손이 뭐가 더 있는지 모르므로 else문 대신 else if 사용
            ((SaleTV) tv).play();
            ((SaleTV) tv).sale();
        }
        // if-else if 문이 아닌 if문 2개 적어주면 비교가 2번씩 수행됨. -> 메모리 낭비
//        if (tv instanceof SaleTV){
//            ((SaleTV) tv).play();
//            ((SaleTV) tv).sale();
//        }
    }

    static void printRentalTV(Rentable tv) {
        tv.rent();
    }
}

```
## 실습 해석

- 계층도
```java
Object

TV

SaleTV
```

- TV에 대한 객체 생성시 조상인 Object에 대한 객체도 생성됨
    - Object에 대한 멤버도 사용할 수 있게 됨

- 자손의 객체는 조상유형의 객체에 대입할 수 있음
- Object형 변수는 Object 까지. Tv형 멤버변수는 Object + Tv가 가지는 멤버들까지 참조할 수 있음.
- 어떤 객체를 생성한다
    - 어떤 객체냐에따라 해당 클래스 유형의 변수에 담아서 써야 형변환 없이 편하게 담아서 사용할 수 있음

- Object 클래스는 toString을 이미 가지고 있음. (TV는 toString을 가지고 있음! Object에게 물려받았으므로 toString을 호출할 수 있다!)
- TV는 자기가 내장하고 있는 것 외에도 Object로부터 물려받은 것 까지는 호출할 수 있는 권한을 가지고 있다


- TV타입의 매개 변수 선언 후
    - SaleTV객체 생성시 SaleTV객체 & TV 객체 & Object는 한 덩어이라고 생각해야함.
    - 따라서 조상으로부터 물려받은 모든 멤버를 객체 생성하게 됨 (메모리 할당하게 됨)
    - 이 객체를 SaleTV형 매개변수에 담아서 사용하면 이 3개 모두의 멤버변수를 사용할 수 있음.

- 자손에서 추가된 것은 호출할 수 없음. 호출하고 싶다면 자손으로 강제 형변환해서 호출해야함.
- toString은 Object로부터 물려받았으므로 어디서든 호출할 수 있음
- toString을 오버라이딩 안하고 호출하려고 하면 최하위 영역부터 최상단 영역까지 거슬러 올라가면서 호출할 toString을 찾아감.
  (Object의 toString은 객체에 대한 참조값을 return함. toString을 하위영역에서 오버라이딩해서 사용해야 원하는대로 출력될 것임)
