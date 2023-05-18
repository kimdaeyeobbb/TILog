package com.example.springnews.controller;

import com.example.springnews.model.News;
import com.example.springnews.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class NewsController {
    @Autowired
    NewsRepository newsRepository;

    /* 전체 뉴스 출력 */
    @GetMapping("/newsmain")
    public ModelAndView getAllNews(){
        List<News> newsList = newsRepository.findAll();
        ModelAndView mav = new ModelAndView();
        if (newsList.size() != 0) {
            mav.addObject("newsList",newsList);
        } else {
            mav.addObject("msg", "추출된 뉴스가 없습니다");
        }
        mav.setViewName("newsBulletins");
        return mav;
    }


    /* 뉴스 제목을 클릭하면 해당 뉴스 내용 출력 */
    // 뉴스 제목을 선택하여 요청. 서버에 id를 보냄. 링크설정을 해주어야 함
    @GetMapping("/listOne")
    public ModelAndView getNewsById(int id) {
        ModelAndView modelAndView = new ModelAndView();
        News newsContents = newsRepository.findById(id).get();
        newsContents.setCnt(newsContents.getCnt()+1);  // 조회수+1
        newsRepository.save(newsContents);  // 변경된 조회수 저장
        modelAndView.addObject("news", newsContents);
        modelAndView.setViewName("newsBulletins");
        return modelAndView;
    }


    /* 뉴스 삭제*/
    // 삭제 버튼을 클릭하여 요청
    // 뉴스 id로 뉴스 삭제
    @GetMapping("/delete")
    public ModelAndView deleteNewsById(int id) {
        ModelAndView mav = new ModelAndView();
        try{
            newsRepository.deleteById(id);
            mav.addObject("newsList", newsRepository.findAll());
        } catch (Exception e){
            mav.addObject("msg", "뉴스를 삭제하는 동안 오류가 발생했습니다 !");
        }
        mav.setViewName("newsBulletins");
        return mav;
    }

    /* 뉴스 검색 */
    // 전달된 검색어로 뉴스글 내용에서 검색하여 결과 출력
    @GetMapping("/search")
    public ModelAndView searchNewsByContent(String keyword) {
        List<News> newsList = newsRepository.findByContentContains(keyword);
        ModelAndView mav = new ModelAndView();
        if(newsList.size() != 0){
            mav.addObject("newsList", newsList);
            mav.addObject("button", "메인화면으로 이동합니다");
        } else {
            mav.addObject("msg", "검색 결과가 없습니다 !");
        }
        mav.setViewName("newsBulletins");
        return mav;
    }

    /* 작성자가 작성한 뉴스 글 출력 */
    // 리스트에 출력된 작성자 이름을 클릭하여 요청
    @GetMapping("/writer")
    public ModelAndView getNewsByWriter(String writer) {
        ModelAndView mav = new ModelAndView();
        List<News> newsContents = newsRepository.findByWriter(writer);

        /* 작성자 클릭시 조회수+!해서 데이터베이스에 반영*/
        newsContents.stream().forEach(item -> {
            item.setCnt(item.getCnt()+1);
            newsRepository.save(item);
        });

        mav.addObject("newsList", newsContents);
        mav.setViewName("newsBulletins");
        return mav;
    }


    /* 뉴스 작성 */
    @PostMapping("/insert")
    @Transactional
    public ModelAndView createNews(News vo) {
        System.out.println(vo);
        ModelAndView mav = new ModelAndView();
        try {
            newsRepository.save(vo);
            mav.addObject("newsList", newsRepository.findAll());
        } catch (Exception e) {
            mav.addObject("msg", "뉴스 작성을 처리하는 동안 오류가 발생하였습니다");
        }
        mav.setViewName("newsBulletins");
        return mav;
    }


    /* 뉴스 수정 */
    @PostMapping("/update")
    @Transactional
    public ModelAndView updateNews(News vo){
        // 클라이언트로부터 News 객체가 가진 필드와 똑같은 이름의 엔티티 객체가 와서 세팅됨.
        ModelAndView mav = new ModelAndView();
        try{
            News oldvo = newsRepository.findById(vo.getId()).get();
            oldvo.setTitle(vo.getTitle());
            oldvo.setWriter(vo.getWriter());
            oldvo.setContent(vo.getContent());
            oldvo.setWritedate(LocalDateTime.now());
            mav.addObject("newsList", newsRepository.findAll());
        } catch (Exception e){
            mav.addObject("msg", "뉴스 수정을 하는동안 오류가 발생하였습니다");
        }
        mav.setViewName("newsBulletins");
        return mav;
    }
}