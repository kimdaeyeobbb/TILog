package com.example.springedu.controller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.example.springedu.domain.FileVO1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController1 {
	@RequestMapping("/uploadForm1")  // 매핑명 정의
	public void formFile() {	   // msg라는 이름으로 전달되는 value가 없음. -> uploadForm1.html이 응답함 (매핑명과 똑같은 애가 응답함)
	}
	@RequestMapping("/upload1")   // 매핑명 정의
	public ModelAndView saveFile(FileVO1 vo) {  // 매개변수 타입 - 도메인 객체. vo클래스 아니면 dto 클래스 중 하나일 것임
		// 멤버변수 이름과 똑같은 이름으로 전달되는 쿼리를 추출하여 세팅한 FileVO1 객체를 생성하여 SAVE 파일에 전달함
		// FileVO1에는 uploadFile이라는 멤버변수가 있어야 함
		String fileName =  vo.getUploadFile().getOriginalFilename();
		// getter 메서드는 해당 멤버변수에 get을 붙여서 생셩됨 -> getUploadFile

		/* 준비 작업 */
		byte[] content = null;
		ModelAndView mav = new ModelAndView();
		mav.setViewName("uploadForm1");
		try {
			content =  vo.getUploadFile().getBytes();  // getBytes -> 업로드된 파일의 모든 바이트 내용을 읽어서 리턴
			File f = new File("c:/uploadtest/"+fileName);  // 서블릿시간에 만든것이 쓰였을 것임 (맥은 알맞게 경로 변경할 것)
			if ( f.exists() ) {
				mav.addObject("msg", fileName + " : 파일이 이미 존재해요!!");
			} else {
				FileOutputStream fos = new FileOutputStream(f);  // 자바의 FileIO API
				fos.write(content);  // write -> 바이트형 배열이 한번에 파일로 나감 (transferTo를 쓰는것이 더 편할 것임)
				fos.close();  // write 후 close를 해야함
				mav.addObject("msg", fileName + ": 파일이 저장되었어요!!");   // VIEW에게 저장되었다는 메시지를 전달
			}
		} catch (IOException e) {
			e.printStackTrace();
			mav.addObject("msg", "오류가 발생했어요!!");
		}
		return mav;
	}
}

