package day13.course;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest2 {
	public static void main(String[] args) {
		String path = "C:/iotest";
		File isDir = new File(path);
		if (!isDir.exists()) {
			isDir.mkdirs();
		}
		try {
			URL req = new URL("http://img.etnews.com/news_ebuzz/afieldfile/2012/01/04/c_bk010101_87984_3.jpg");
			InputStream is = req.openStream();
			// 오픈스트림 호출 - 해당 웹서버에 접속하고 요청까지 보낸다음 응답을 가디라고 있다는 것.
			// 응답이 오면 inputstreamd을 리턴받음

			String fileName = "c:/iotest/duke.jpg";
			// 응답받을 경우의 파일을 미리 지정

			FileOutputStream fos = new FileOutputStream(fileName);
			int input = 0;
			while (true) {
				input = is.read();
				if (input == -1)
					break;
				fos.write(input);
			}
			fos.close();
			System.out.println("duke.jpg가 성공적으로 저장되었습니다.");
			Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application"
					+ "\\chrome.exe "+fileName);
			// exe 뒤에 공백을 줘야 뒤에 파일과 제대로 구분해서 인식함.
		} catch (MalformedURLException e) {
			System.out.println("URL문자열 오류 : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO 오류 : " + e.getMessage());
		}
	}
}
