package com.example.springedu.controller;

import com.example.springedu.dao.BookMybatisDAO;
import com.example.springedu.domain.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    BookMybatisDAO dao;

    @GetMapping("/book")
    public String getbookPage() {
        return "bookPage";
    }


    @GetMapping(value = "/bookinfo/b{num}", produces = "text/html; charset=utf-8")
    public ModelAndView bookinfo(@PathVariable int num) {
        ModelAndView mav = new ModelAndView();
        List<BookDTO> list = null;

        switch (num) {
            case 1:
                System.out.println("1번");
                list = dao.b1();
                System.out.println("1번 리스트" + list);
                break;
            case 2:
                System.out.println("2번");
                list = dao.b2();
                System.out.println("2번 리스트" + list);
                break;
            case 3:
                System.out.println("3번");
                list = dao.b3();
                System.out.println("3번 리스트" + list);

                break;
            case 4:
                System.out.println("4번");
                list = dao.b4();
                System.out.println("4번 리스트" + list);
                break;
            case 5:
                System.out.println("5번");
                list = dao.b5();
                System.out.println("5번 리스트" + list);
                break;
            case 6:
                System.out.println("6번");
                list = dao.b6();
                System.out.println("6번 리스트" + list);
                break;
            case 7:
                System.out.println("7번");
                list = dao.b7();
                System.out.println("7번 리스트" + list);
                break;
            default:
                System.out.println("8번");
                list = dao.b8();
                System.out.println("8번 리스트" + list);
                break;
        }
        if (list.size() != 0) {
            mav.addObject("list", list);
        } else {
            mav.addObject("nullMsg", "추출된 데이터가 없습니다");
        }
        mav.setViewName("bookPage");
        return mav;
    }

}
