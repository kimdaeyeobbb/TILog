package com.example.springedu.domain;

import lombok.AllArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import lombok.Getter;
import lombok.Setter;
@Getter
@AllArgsConstructor
public class FileVO2 {
	private MultipartFile[] uploadFiles;
	// MultipartFile형 배열 변수 -> 파일을 원하는 만큼 업로드 (다중파일 업로드가 가능) -> 여러개의 파일이 올 수 있으므로 전달되는 part 개수만큼 반복처리해야함
}
