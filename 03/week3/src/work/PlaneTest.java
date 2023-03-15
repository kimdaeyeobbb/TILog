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
