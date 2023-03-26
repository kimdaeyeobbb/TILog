package day0322.course;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest1 {
	public static void main(String[] args) {
		try {
			URL req = new URL("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1171062000");
			// ? 뒤에 있는것은 쿼리 문자열
			// zone= 뒤에있는것이 zone number (지역번호. 아마 동 번호...?)
			// URL은 :가 꼭 있어야 함. 얘를 빠뜨리면 URL 문자열은 제대로 된 URL 문자열로 인정받지 못함.
			// HTTP 프로토콜이 없다고 인식해서 -> My formed URL Exception 발생


			// 응답된 내용을 직접 읽어오는 것은 자바 I/O API이용해서 우리가 직접 구현해야 함
			// XML은 100% UTF8임
			InputStream is = req.openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String lineStr = "";
			while (true) {
				lineStr = reader.readLine();
				if (lineStr == null)
					break;
				System.out.println(lineStr);
			}
		} catch (MalformedURLException e) {
			System.out.println("URL문자열 오류 : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO 오류 : " + e.getMessage());
		}
	}
}
