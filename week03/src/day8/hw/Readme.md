
# [과제](../../mobile/MobileTest.java)

```java
package mobile;

abstract class Mobile{
    private String mobileName;
    private int batterySize;
    private String osType;

    public Mobile(){}
    public Mobile(String mobileName, int batterySize, String osType){
        this.mobileName = mobileName;
        this.batterySize = batterySize;
        this.osType = osType;
    }

    /* abstract method */
    public abstract void operate(int time);
    public abstract void charge(int time);

    /* getter & setter */
    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public int getBatterySize() {
        return batterySize;
    }

    public void setBatterySize(int batterySize) {
        this.batterySize = batterySize;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }
}

class Ltab extends Mobile{
    public Ltab(){};
    public Ltab(String mobileName, int batterySize, String osType){
        super(mobileName,batterySize,osType);
    };
    public void operate(int time){
        setBatterySize(getBatterySize()-10*time);
    };
    public void charge(int time){
        setBatterySize(getBatterySize()+10*time);
    };
}

class Otab extends Mobile{
    public Otab(){};
    public Otab(String mobileName, int batterySize, String osType){
        super(mobileName,batterySize,osType); // super 메서드를 통해 조상 생성자 처리
    };
    public void operate(int time){
        setBatterySize(getBatterySize()-12*time);
    };
    public void charge(int time){
        setBatterySize(getBatterySize()+8*time);
    };
}


public class MobileTest {
    public static void main(String[] args) {
        /* 객체 생성 */
        Mobile mobL = new Ltab("Ltab", 500, "ABC-01");
        Mobile mobO = new Otab("Otab", 1000, "XYZ-20");

        printTable();
        printMobile(mobL);
        printMobile(mobO);

        System.out.println("\n[ 10분 충전 ]");
        printTable();
        mobL.charge(10);
        printMobile(mobL);
        mobO.charge(10);
        printMobile(mobO);

        System.out.println("\n[ 5분 통화 ]");
        printTable();
        mobL.operate(5);
        printMobile(mobL);
        mobO.operate(5);
        printMobile(mobO);
    }

    /* 모바일 정보 출력 */
    public static void printMobile(Mobile mobile) { // 매개변수가 모바일형 (모바일의 자손을 전달하겠구나! 하고 예측 가능)
        System.out.printf(mobile.getMobileName() +"     " +mobile.getBatterySize() +"        " +mobile.getOsType()+"\n");
    }

    /**/
    public static void printTable(){
        System.out.printf("Mobile\t Battery \t OS\n");
        System.out.printf("----------------------------\n");
    }
}

```

- 이름이 이탤릭체
    - 추상클래스 혹은 추상 메서드임을 뜻함
- getter, setter의 getXXX, setXXX
    - 각 멤버변수들을 뜻함
- abstract
    - 활용 제어자 (혹은 일반 제어자)
- 일반적으로 접근 제어자를 먼저 작성하고 활용제어자를 이후에 작성함

- 메서드를 만들 떄에는 단일 책임 원칙
    - 메서드 하나당 하나의 기능을 수행하게끔 설계하는것이 좋다

- 객체 중 조상객체도 포함되어 있을 수 있는데, 오버라이딩한 것이 우선적으로 처리됨.
  항상 자손객체 영역부터 찾아가서 메서드를 불러오고 없으면 조상으로 올라감.

# 과제2

```java
package work;

abstract class Plane{
  private String planeName;
  private int fuelSize;

  /* 기본 생성자 */
  public Plane(){}   // create 표시 -> 생성자 메서드
  public Plane(String planeName, int fuelSize){
    this.planeName = planeName;
    this.fuelSize = fuelSize;
  }

  /* GETTER & SETTER */
  public void setPlaneName(String planeName) {
    this.planeName = planeName;
  }

  public int getFuelSize() {
    return fuelSize;
  }

  public void setFuelSize(int fuelSize) {
    this.fuelSize = fuelSize;
  }

  public String getPlaneName() {
    return planeName;
  }

  /* refuel -> 일반 메서드 */
  public void refuel(int fuel){
    fuelSize += fuel;
  }

  public abstract void flight(int distance);
}

class Airplane extends Plane{
  public Airplane(){};
  public Airplane(String planeName, int fuelSize){
    super(planeName,fuelSize);
  };

  @Override
  public void flight(int distance) {
    setFuelSize(getFuelSize()-3*distance);
  }
}

class Cargoplane extends Plane{
  public Cargoplane(){};
  public Cargoplane(String planeName, int fuelSize){
    super(planeName, fuelSize);
  };

  @Override
  public void flight(int distance) {
    setFuelSize(getFuelSize()-5*distance);
  }
}

public class PlaneTest {
  public static void main(String[] args) {
    /* 객체 생성 */
    Plane pl[] = new Plane[2];
    pl[0] = new Airplane("L747",1000);
    pl[1] = new Cargoplane("C40", 1000);

    printInfo(pl);

    System.out.println("\n\t[100 운항]");
    for (int i=0; i< pl.length; i++){
      pl[i].flight(100);
    }
//        pl[0].flight(100);
//        pl[1].flight(100);
    printInfo(pl);

    System.out.println("\n\t[200 주유]");
    for (int i=0; i< pl.length; i++){
      pl[i].refuel(200);
    }
//        pl[0].refuel(200);
//        pl[1].refuel(200);
    printInfo(pl);
  }

  public static void printInfo(Plane[] list){
    System.out.printf("\t%s \t\t %s\n", "Plane", "fuelSize");
    System.out.printf("----------------------------\n");
    for (Plane el: list){
      System.out.printf("\t%s \t\t %d\n", el.getPlaneName(), el.getFuelSize());
    }
//        System.out.printf("\t%s \t\t %d\n", list[0].getPlaneName(), list[0].getFuelSize());
//        System.out.printf("\t%s \t\t %d\n", list[1].getPlaneName(), list[1].getFuelSize());
  }
}

```

- 지역변수와 멤버변수가 이름이 같은데 구분해야 할 때 `this`사용
- private을 다룰 때 getter & setter를 이용할 것
- Plane은 추상 클래스
    - 직접 객체 생성할 수 없음