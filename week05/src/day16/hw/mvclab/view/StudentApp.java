package day16.hw.mvclab.view;

import day16.hw.mvclab.controller.StudentController;
import java.util.Scanner;

public class StudentApp {
    public static void main(String[] args) {
        StudentController stdctrl = new StudentController();
        Scanner sc = new Scanner(System.in);
        loop: while(true){
            System.out.println("\n처리하려는 기능을 선택하세요.");
            System.out.println("1. 학생 정보 출력");
            System.out.println("2. 학생 정보 입력");
            System.out.println("3. 학생 정보 삭제");
            System.out.println("4. 학생 정보 수정");
            System.out.println("5. 학생 점수 확인");
            System.out.println("6. 종료");
            System.out.print("입력 : ");
            String aws = "";
            aws = sc.nextLine();
            switch (aws){
                /* READ */
                case "1":
                    stdctrl.printAll();
                    break;

                /* CREATE */
                case "2":
                    System.out.print("학생 이름을 입력하세요: ");
                    String insertName = sc.nextLine();
                    System.out.print("학생의 성적을 입력하세요: ");
                    int score = sc.nextInt();
                    stdctrl.insert(insertName, score);
                    break;

                /* DELETE */
                case "3":
                    System.out.print("삭제하려는 학생 이름을 입력하세요: ");
                    String delName = sc.nextLine();
                    stdctrl.delete(delName);
                    break;

                /* UPDATE */
                case "4":
                    System.out.print("수정하려는 학생 이름을 입력하세요: ");
                    String updateName = sc.nextLine();
                    System.out.print("수정하려는 학생의 점수를 입력하세요: ");
                    int updateScore = sc.nextInt();
                    stdctrl.update(updateName, updateScore);
                    break;

                /* READ */
                case "5":
                    System.out.print("점수를 확인하고 싶은 학생의 이름을 입력하세요: ");
                    String checkName = sc.nextLine();
                    stdctrl.printScore(checkName);
                    break;

                case "6":
                    break loop;
            }
        }
        System.out.println("프로그램을 종료합니다");
    }
}
