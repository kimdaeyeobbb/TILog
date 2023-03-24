package day0324.day15;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertImage {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
			return;
		} 
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				Scanner scan = new Scanner(System.in);
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO imgtest (filename, imgcontent) VALUES (?, ?)")){
			// imgtest 테이블에 inset
			// 테이블의 컬럼 중 filename, imgcontent 컬럼에 데이터를 넣겠다는 것. (id컬럼에는 데이터 안넣음. 자동적으로 증가하니까.)
			// VALUES - 첫번쨰 물음표: filename, 두번째 물음표: imgcontent 넣음
			System.out.print("저장할 이미지 파일명을 절대 패스로 입력하세요 : ");
			// 맥: 최상위 폴더부터. 윈도우:
			// c:/iotest/myimage/cuteone.jpg
			// 확장자까지 제대로 입력할 것

			String name = scan.nextLine();
			File imgFile = new File(name);
			if (imgFile.exists()) { // 이미지 파일이 존재한다면
				/* DB테이블에 집어넣음 */
				FileInputStream fin = new FileInputStream(imgFile);
				// 이미지는 바이트 스트림으로 설정해야함 (문자 스트림으로 설정하면 이미지가 다 깨짐)

				pstmt.setString(1, imgFile.getName());
				// getName -> 파일이름만 추출

				pstmt.setBinaryStream(2, fin, (int)imgFile.length());
				// setBinaryStream - byte형식으로 동작하는 스트림객체를 설정.
				// 두번쨰 물음표에 fin (FileInputStrea - 객체 생성시 파일을 읽기 모드로.)
				// 이미지니까 문자 스트림 X (이미지 다 꺠짐), 바이트 스트림을 써서 읽어와야 함.
				// length - 읽고자하는 이미지 파일의 사이즈(만큼 읽어서 세팅해달라는 것)

				pstmt.executeUpdate(); 
				System.out.println("이미지 삽입 성공");
			} else {
				System.out.println("[오류] 이미지가 존재하지 않음");
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
