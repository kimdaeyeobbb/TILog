package day15.course;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SelectImage {
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
				PreparedStatement pstmt = conn.prepareStatement("SELECT filename, imgcontent FROM imgtest WHERE filename = ?");) {
			System.out.print("읽으려는 이미지의 파일명을 입력하세요 : ");
			String name = scan.nextLine();
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				/* 새로 만들 파일의 이름 처리  & 이미지 파일의 내용을 읽어옴*/
				String imgName[] = rs.getString("filename").split("\\.");
				// split 호출시 delimeter 지정함.
				// 여기서는 점(.)을 기준으로해서 양쪽을 나눔
				// \을 이용해서 점의 고유의미를 없앰. 자바에서는 더블 인용 부호내에 백슬래쉬를 쓰려면 2번을 써야함. 따라서 \\.가 된것.
				// (\\을 통해 점(.)의 정규표현식에서의 고유의미를 없애고, 문자로서의 점으로 사용)
				//

				File imgFile = new File("c:/Temp/"+imgName[0]+new Date().getTime()+"."+imgName[1]);
				// 현재 시스템 시간에 대한 timestamp값을 붙임 & 확장자 붙임

				/* 입출력 스트림 사용 & 바이트 스트림으로 읽어오게끔 만듦 */
				InputStream is = rs.getBinaryStream("imgcontent");
				// 직접 안주니까 읽어와야 함

				/* 읽어와서 파일에 저장 */
				FileOutputStream fos = new FileOutputStream(imgFile);
				byte[] b = new byte[2048];
				// 2048 바이트씩 읽어와서 write처리하기 위한 과정 (1바이트씩 읽어오면 시간이 오래걸리니까)
				int n;
				while ((n = is.read(b)) > 0) {
					fos.write(b, 0, n);
				}
				fos.close();
			} else {
				System.out.print(name + "이라는 파일명으로 저장된 이미지가 존재하지 않습니다. ");
			}
			System.out.println("이미지 읽기 성공");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
