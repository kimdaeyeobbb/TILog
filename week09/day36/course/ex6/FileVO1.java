package week09.day36.course.ex6;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@AllArgsConstructor
public class FileVO1 {
	private MultipartFile uploadFile;	
}
