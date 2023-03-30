package day12.course;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest2 {
	public static void main(String args[]) {
		FileReader reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader("c:/iotest/output.txt"); // 파일을 읽기모드로 오픈

			br = new BufferedReader(reader); // 버퍼드 리더객체를 마저 생성
			// 파일리더 객체를 버퍼리 리더가 감쌈
			while (true) {
				String data = br.readLine();
				// 행단위로 읽음
				// 리턴값: string. 더 이상 읽을 것이 없으면 null을 리턴
				if (data == null)
					break;
				System.out.println(data);
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (IOException ioe) {
			System.out.println("파일을 읽을 수 없습니다.");
		} finally {
			try {
				br.close();
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
