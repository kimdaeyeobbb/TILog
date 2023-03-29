package day18.course;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamExample5 {
	public static void main(String[] args) throws Exception {
		Path path = Paths.get("data.txt");   // 현재 프로젝트 폴더 경로에 위치시키면 됨
		Stream<String> stream = Files.lines(path, Charset.defaultCharset());
		// UFT-8로 세팅하면 결과가 UTF-8로 나옴 (data.txt를 UTF-8로 설정해서 넘겨받음)
		// 파일의 내용을 행 단위로 읽어서 각각이 스트림 객체가 되게 만듦

		stream.forEach(line -> System.out.println(line));
		stream.close();
	}
}