package day0316.hw;

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
