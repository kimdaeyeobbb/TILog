package day16.hw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateBookLab {
    public static void main(String[] args) {
        /* DB������ ���� ���� ���� */
        String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
        String user = "jdbctest";
        String passwd = "jdbctest";


        try( /* DB ������ ���� ��ü ���� - Ŭ�������� �߰�����ؾ��� */
                Connection conn = DriverManager.getConnection(url, user, passwd);
            Statement stmt = conn.createStatement();){
            /* ���̺� ���� ���� */
            stmt.executeUpdate("create table book " +
                    "(id int primary key auto_increment not null " +
                    ",title varchar(90)" +
                    ", price int" +
                    ", kind char(3))");
            System.out.println("book ���̺� ���� �Ϸ�!");
        } catch (SQLException sel){
            System.out.println("���� �߻�! ���� �޽���: " +sel);
        }
    }
}
