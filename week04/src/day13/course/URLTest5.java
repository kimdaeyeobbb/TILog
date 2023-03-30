package day13.course;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class URLTest5 {
	public static void main(String[] args) throws Exception {
		URL url = new URL("https://www.kobis.or.kr/kobis/business/main/main.do");
		InputStream is = url.openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		// UTF-8은 디폴트값이므로 생략해도 됨
		String line = null;

		while (true) {
			line = br.readLine();
			if (line == null)
				break;
			System.out.println(line);
		}
	}
}
