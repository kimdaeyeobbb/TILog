package day16.hw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertBookLab {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
        String user = "jdbctest";
        String passwd = "jdbctest";
        int cnt=0;
        try(Connection conn = DriverManager.getConnection(url, user, passwd);
            PreparedStatement pstmt = conn.prepareStatement("insert into book(title,price,kind) values (?,?,?)");
            Scanner sc = new Scanner(System.in);){
            start: while(true){    // �ݺ����� start ��� ���� ����
                /* ������� ���� �Է¹��� */
                System.out.print("�������� �Է��ϼ��� : ");
                String title = sc.nextLine();
                System.out.print("������ �Է��ϼ��� : ");
                int price = Integer.parseInt(sc.nextLine());

                /* ���� �з��� ���� ���� �Է� */
                System.out.println("���� �з��� ���� ���ڸ� �Է��ϼ���.");
                System.out.println("1. ���α׷��� ���");
                System.out.println("2. �� ���α׷���");
                System.out.println("3. ������");
                System.out.println("4. �����ͺ��̽�");
                System.out.println("5. ������");
                System.out.println("���� (1~5) : ");

                System.out.println("������ �ԷµǾ����ϴ�.");

                int kind = sc.nextInt();
                sc.nextLine();  // �Է¹��� û��
                if (kind > 5 || kind < 1){
                    System.out.println("�߸��� �Է��Դϴ�. ��������� �ٽ� �Է��ϼ���");
                    continue;  // �ٽ� while�� ���� �ö󰡵��� ���� (��������� �ٽ� �Է�)
                }

                /* ���� �� �ݿ� */
                pstmt.setString(1,title);
                pstmt.setInt(2, price);
                pstmt.setString(3, "b0"+String.valueOf(kind));
                pstmt.executeUpdate();
                System.out.println("\nbook ���̺� ������ ���� �Ϸ�");
                cnt++;
                while(true){
                    System.out.println("��� �Է��Ͻðڽ��ϱ�? (y/n) ");
                    String aws = sc.nextLine();
                    if (aws.equalsIgnoreCase("n")){
                        System.out.println(cnt+"���� ������ �Է� �Ϸ�!");
                        break start;  // start��� ���� ������ �ݺ����� ����
                    } else if (aws.equalsIgnoreCase("y")) {
                        System.out.println();
                        break;  // �� while���� ����
                    } else {
                        System.out.println("y�� n �� �� �ϳ��� �Է��ϼ���");
                        System.out.println("y�� ����ϰ� n�� �׸��ϱ� �Դϴ�.");
                    }
                }
            }
        } catch (SQLException se){
            System.out.println("���� �߻� : "+se.getMessage());
            se.printStackTrace(); // �ݽ��� ���� ���
        }  // try-catch ������ ����Ͽ����Ƿ� close�� �ڵ����� ����
    }
}
