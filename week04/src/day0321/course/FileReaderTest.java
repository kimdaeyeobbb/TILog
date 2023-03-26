package day0321.course;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
	public static void main(String args[]) {
		FileReader reader = null;
		try {
			reader = new FileReader("c:/iotest/output.txt");
//			reader = new FileReader("c:/iotest/outputt.txt");
			// outputt으로 수정하면 FileNotFoundException 발생
			while (true) {
				int data = reader.read();
				if (data == -1)
					break;
				char ch = (char) data;
				System.out.print(ch);
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (IOException ioe) {
			System.out.println("파일을 읽을 수 없습니다.");
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
