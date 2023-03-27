package day16.hw;

import java.sql.*;
import java.util.Scanner;

public class SelectBookLab {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
        String user = "jdbctest";
        String passwd = "jdbctest";
        try(Connection conn = DriverManager.getConnection(url, user, passwd);
            Statement stmt = conn.createStatement();
            Scanner sc = new Scanner(System.in);){
            while(true) {
                System.out.println("1. ��� ����ϱ�");
                System.out.println("2. ������ ���� ������ ����ϱ�");
                System.out.println("3. 20000 �̻��� �����鸸 ����ϱ� (3�� �Է½� 2���� �̻��� �����鸸 ���)");
                System.out.println("4. �� ���α׷��� �����鸸 ����ϱ�");
                System.out.println("5. �����ͺ��̽��� ������ �����鸸 ����ϱ�");
                System.out.println("6. ������ '�ڹ�'�� �����ϴ� �����鸸 ����ϱ�");
                System.out.println("7. �з��� ���� ������ ����� ����ϱ� (GROUP BY�� �Ἥ ��ձ��ϱ�)");
                System.out.println("���ϴ� �޴��� ��ȣ�� ���� : ");

                int num = Integer.parseInt(sc.nextLine());
                ResultSet rs;
                String sqlStr = "";
                switch (num) {
                    case 1:
                        sqlStr = "select id, title, format(price, 0), kind from book";
                        break;
                    case 2:
                        sqlStr = "select id, title, format(price, 0), kind from book order by price desc";
                        break;
                    case 3:
                        sqlStr = "select title, format(price, 0) from book where price >= 20000";
                        break;
                    case 4:
                        sqlStr = "select title, format(price, 0) from book where kind like '%b02%'";
                        break;
                    case 5:
                        sqlStr = "select title, format(price, 0) from book where kind like '%b04%' and like '%b05%'";
                        break;
                    case 6:
                        sqlStr = "select title, format(price, 0) from book where title like '%�ڹ�%'";
                        break;
                    case 7:
                        sqlStr = "select kind, format(avg(price), 0) from book group by kind";
                        break;
                }
                rs = stmt.executeQuery(sqlStr);
                String bookName = "";
                String bookNum = rs.getString(1);
                if(rs.next()) {
                    do {
                        if(num < 3){
                            System.out.println(rs.getString(1)+ " " + rs.getString(2) + " " + rs.getString(3) + "  " + rs.getString(4));
                        } else if (num <7){
                            System.out.println(rs.getString(1)+"�� ������ "+rs.getString(2)+"�� �Դϴ�.");
                        } else {
                            if (bookNum.equals("b01")){
                                bookName = "���α׷��� ���";
                            } else if (bookNum.equals("b02")){
                                bookName = "�� ���α׷���";
                            } else if (bookNum.equals("b03")){
                                bookName = "������";
                            } else if (bookNum.equals("b04")){
                                bookName = "�����ͺ��̽�";
                            } else if (bookNum.equals("b05")){
                                bookName = "������";
                            }
                            System.out.println(bookName+" �������� ���� ����� "+rs.getString(2)+"�� �Դϴ�.");
                        }
                    } while (rs.next());
                } else {
                    System.out.println("ã���ô� å�� �����ϴ�.");
                }

                System.out.println("��� �Է��Ͻðڽ��ϱ�? (n �Է½� ����) ");
                String aws = sc.nextLine();
                if(aws.equalsIgnoreCase("n")){
                    System.out.println("�����մϴ�.");
                    rs.close();
                    break;
                }
            }
        } catch (SQLException se){
            System.out.println(se.getMessage());
        }
    }
}
