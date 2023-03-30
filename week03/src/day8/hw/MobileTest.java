package day8.hw;


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

class Ltab extends Mobile {
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

class Otab extends Mobile {
    public Otab(){};
    public Otab(String mobileName, int batterySize, String osType){
        super(mobileName,batterySize,osType);
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
    public static void printMobile(Mobile mobile) {
        System.out.printf(mobile.getMobileName() +"     " +mobile.getBatterySize() +"        " +mobile.getOsType()+"\n");
    }

    /**/
    public static void printTable(){
        System.out.printf("Mobile\t Battery \t OS\n");
        System.out.printf("----------------------------\n");
    }
}
