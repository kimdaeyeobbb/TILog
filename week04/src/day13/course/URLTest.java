package day13.course;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class URLTest {
	public static void main(String[] args) throws Exception {  // throws: 소극적인 예외처리
		// URL url = new URL("http://unico2013.dothome.co.kr/test_utf8.html");
		URL url = new URL("http://unico2013.dothome.co.kr/test_euckr.html");
		InputStream is = url.openStream();
		// BufferedReader br = new BufferedReader(new InputStreamReader(is));
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "EUC-KR"));
		// 응답된 내용을 행 단위로 읽어오기 위해서 BufferedReader 이용
		// 읽을 떄 EUC-KR처럼 읽을 것임을 명시해주어야 함 (응답되는 내용을 어떻게 읽을것인지 바꾸지 않으면 UTF8로 설정됨)
		// openStream이 리턴하는 것은 바이트스트림 객체이므로 형변환을 해주어야 함

		String line = null;
		while (true) {
			line = br.readLine();
			if (line == null)
				break;
			System.out.println(line);
		}
	}
}
