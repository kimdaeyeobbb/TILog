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
            while(true){
                /* ������� ���� �Է¹��� */
                System.out.println("�������� �Է��ϼ��� : ");
                String title = sc.nextLine();
                System.out.println("������ �Է��ϼ��� : ");
                int price = Integer.parseInt(sc.nextLine());
                System.out.println("���� �з��� ���� �ѹ��� �Է��ϼ���.");
                System.out.println("1. ���α׷��� ���");
                System.out.println("2. �� ���α׷���");
                System.out.println("3. ������");
                System.out.println("4. �����ͺ��̽�");
                System.out.println("5. ������");
                System.out.println("���� (1~5) : ");
                String kind = "b0";
                kind += sc.nextLine();
                System.out.println("������ �ԷµǾ����ϴ�.");

                /* ���� �� �ݿ� */
                pstmt.setString(1,title);
                pstmt.setInt(2, price);
                pstmt.setString(3,kind);
                pstmt.executeUpdate();
                System.out.println("book ���̺� ������ ���� �Ϸ�");
                cnt++;
                System.out.println("��� �Է��Ͻðڽ��ϱ�? (y/n) ");
                String aws = sc.nextLine();
                if (aws.equalsIgnoreCase("n")){
                    System.out.println(cnt+"���� ������ �Է� �Ϸ�!");
                    System.out.println("book ���̺� ������ ���� �۾� ����");
                    break;
                }
            }
        } catch (SQLException se){
            System.out.println(se.getMessage());
        }
    }
}
