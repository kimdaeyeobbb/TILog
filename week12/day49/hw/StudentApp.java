package jpamvcexam.mainview;

import jpamvcexam.controller.StudentController;

import java.util.Scanner;

public class StudentApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentController stuc = new StudentController();
        while (true){
            System.out.println("===============================");
            System.out.println("1. 학생 정보 출력");
            System.out.println("2. 학생 정보 입력");
            System.out.println("3. 학생 정보 삭제");
            System.out.println("4. 학생 정보 수정");
            System.out.println("5. 학생 점수 확인");
            System.out.println("6. 종료");
            System.out.println("처리하려는 작업에 대한 번호를 입력하세요: ");


            int num = sc.nextInt();
            sc.nextLine();

            if (num == 1){
                stuc.printAll();
            } else if (num == 2){
                System.out.println("학생 정보를 삽입합니다 ");

                System.out.println("학생이름을 입력하세요: ");
                String name = sc.nextLine();

                System.out.println("점수를 입력하세요: ");
                int score = sc.nextInt();
                stuc.insert(name, score);
            } else if (num == 3){
                System.out.println("삭제하려는 학생의 이름을 입력하세요: ");
                String name = sc.nextLine();
                stuc.delete(name);
            } else if (num == 4){
                System.out.println("수정하려는 학생의 이름을 입력하세요: ");
                String name = sc.nextLine();

                System.out.println("수정하려는 학생의 점수를 입력하세요: ");
                int score = sc.nextInt();


                stuc.update(name, score);
            } else if (num == 5){
                System.out.println("점수를 확인하고 싶은 학생의 이름을 입력하세요: ");
                String name = sc.nextLine();
                stuc.printScore(name);
            } else {
                stuc.close();
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
        sc.close();
    }
}
