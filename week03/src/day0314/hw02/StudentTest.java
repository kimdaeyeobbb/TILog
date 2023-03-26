package day0314.hw02;  // 제출시 packge exercise로 변경

class Human{
    private String name;
    private int age;
    private int height;
    private int weight;

    public Human(){}

    public Human(String name, int age, int height, int weight){
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public String printInformation(){
        return name + "\t" + age + "\t" + height + "\t" + weight;
    }
}

class Student extends Human{
    private String number;
    private String major;

    public Student(){

    }

    public Student(String name, int age, int height, int weight, String number, String major){
        super(name, age, height, weight);
        this.number = number;
        this.major = major;
    }

    @Override
    public String printInformation() {
        return super.printInformation() + "\t" + number + "\t" + major;
    }
}

public class StudentTest {
    public static void main(String[] args) {
        Student arrays[] = new Student[3];
        arrays[0] = new Student("홍길동", 20, 171,81,"2001101","영문");
        arrays[1] = new Student("고길동", 21, 183,72,"2001102","건축");
        arrays[2] = new Student("박길동", 22, 175,65,"2001103","컴공");

        for(Student st: arrays){
            System.out.println(st.printInformation());
        }
    }
}
