package com.example.springedu.controller;

import com.example.springedu.domain.LottoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

@Controller
public class LottoController {
    @RequestMapping(value="/lotto")
    public String handle(@ModelAttribute("choice") LottoDTO lottoDTO, int lottoNum, HttpSession s){

        /* 랜덤 번호 */
        lottoDTO.setLottoNum(lottoNum);
        int randNum = (int)(Math.random()*6)+1;
        s.setAttribute("randNum", randNum);
        System.out.println("랜덤번호:" +randNum);

        /* 응모횟수 */
        if (s.getAttribute("count") == null){
            s.setAttribute("count", 0);
        }
        Integer count = (Integer)(s.getAttribute("count"));
        System.out.println("count : " + count);
        s.setAttribute("count", count+1);

        /* 결과 넘겨주기 */
        if (count >= 3 ){
            lottoDTO.setResult("로또 응모는 낙첨된 경우에 한하여 3번 까지만 가능합니다<br>브라우저를 재기동한 후에 응모한 후에 응모해 주세요");
            lottoDTO.setImgName("images/snow.png");
        }else {
            if (lottoNum == randNum) {
                lottoDTO.setResult("추카추카");
                lottoDTO.setImgName("images/sun.png");

            } else {
                lottoDTO.setResult("아쉽네요... 다음 기회를!!");
                lottoDTO.setImgName("images/rain.png");
            }
        }
        return "lottoView";
    }
}