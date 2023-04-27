package com.example.springedu.controller;
import java.io.File;
import java.io.IOException;

import com.example.springedu.domain.FileVO2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController2 {
	@RequestMapping("/uploadForm2")
	public void formFile() {
	}
	@RequestMapping("/upload2")
	public ModelAndView saveFile(FileVO2 vo) {
		System.out.println(vo.getUploadFiles().length+"개가 업로드 됨");
		String resultStr = "";
		String path = "c:/uploadtest/multi";
		File isDir = new File(path);
		if (!isDir.isDirectory()) {
			isDir.mkdirs();
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("uploadForm2");

		// MultipartFile형 배열 변수 -> 파일을 원하는 만큼 업로드 (다중파일 업로드가 가능) -> 여러개의 파일이 올 수 있으므로 전달되는 part 개수만큼 반복처리해야함
		for (MultipartFile mfile : vo.getUploadFiles()) {
			String fileName = mfile.getOriginalFilename();
			try {
				File f = new File("c:/uploadtest/multi/" + fileName);  // multi라는 서브폴더 만들어서 처리
				if (f.exists()) {
					resultStr += fileName + " : 파일이 이미 존재해요!!<br>";
				} else {
					mfile.transferTo(f);  // 읽어서 write 할필요 없이 편하게 transferTo로 수행하여 write (저장할 파일 객체만 전달)
					resultStr += fileName + " : 파일이 저장되었어요!!<br>";
				}
			} catch (IOException e) {
				e.printStackTrace();
				resultStr += fileName + " : 오류가 발생했어요!!";
			}
		}
		mav.addObject("msg", resultStr);
		return mav;
	}
}

