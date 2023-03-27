package day16.hw.mvclab.model;

import day16.course.mvc.MySQLConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDAO {
    /* Create */
    public boolean insertStudent(StudentDTO dto){
        boolean result = false;
        Connection conn = MySQLConnect.connect();

        try(PreparedStatement pstmt = conn
                .prepareStatement("insert into student (name, score) values (?, ?)");){

                pstmt.setString(1, dto.getName());
                pstmt.setInt(2, dto.getScore());
//                pstmt.executeUpdate();
                if(pstmt.executeUpdate() > 0 ){ // 비교할 때에도 함수가 실행됨
                    result = true;
                }
        } catch (SQLException se){
            System.out.println(se.getMessage());
        }
        MySQLConnect.close(conn);
        return result;
    }

    /* Read */
    public List<StudentDTO> getAllStudent(){
        Connection conn = MySQLConnect.connect();
        List<StudentDTO> stdlist = null;
        try (Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(
                    "select name, score from student");
            stdlist = new ArrayList<StudentDTO>();
            while (rs.next()) {
                StudentDTO stdo = new StudentDTO();
                stdo.setName(rs.getString("name"));
                stdo.setScore(rs.getInt("score"));
                stdlist.add(stdo);
            }
        } catch (SQLException se){
            System.out.println(se.getMessage());
        }
        MySQLConnect.close(conn);
        return stdlist;
    }

    /* Read */
    public int getScore(StudentDTO dto){
        Connection conn = MySQLConnect.connect();
        int score = -1;
        try(PreparedStatement pstmt = conn.prepareStatement("select score  from student where name = ?");){
            pstmt.setString(1, dto.getName());
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                dto.setScore(rs.getInt("score"));
                score = dto.getScore();
            }
        } catch (SQLException se){
            System.out.println(se.getMessage());
        }
        MySQLConnect.close(conn);
        return score;
    }

    /* Update */
    public boolean updateStudent(StudentDTO dto){
        boolean result = false;
        Connection conn = MySQLConnect.connect();
        try(PreparedStatement pstmt = conn.prepareStatement("update student set score = ? where name = ? ")){
            pstmt.setInt(1, dto.getScore());
            pstmt.setString(2, dto.getName());
//            pstmt.executeUpdate();
            if (pstmt.executeUpdate() > 0){
                result = true;
            }
        } catch (SQLException se){
            System.out.println(se.getMessage());
        }
        MySQLConnect.close(conn);
        return result;
    }

    /* Delete */
    public boolean deleteStudent(StudentDTO dto){
        boolean result = false;
        Connection conn = MySQLConnect.connect();
        try(PreparedStatement pstmt = conn.prepareStatement("delete from student where name = ?")){
            pstmt.setString(1, dto.getName());
            if (pstmt.executeUpdate() > 0){
                result = true;
            }
        } catch (SQLException se){
            System.out.println(se.getMessage());
        }
        MySQLConnect.close(conn);
        return result;
    }
}
