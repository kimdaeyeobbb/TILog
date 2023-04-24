package com.example.springedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcController {
    @RequestMapping("/calc")
    public ModelAndView proc(@RequestParam(value="firstNum", defaultValue="숫자 없음") int firstNum,
                             @RequestParam(value="operator", defaultValue = "+") String operator,
                             @RequestParam(value="secondNum", defaultValue = "숫자 없음") int secondNum){
        ModelAndView mav = new ModelAndView();
        mav.addObject("firstNum", firstNum);
        mav.addObject("operator", operator);
        mav.addObject("secondNum", secondNum);
        System.out.println(firstNum + " " + operator + " " + secondNum);

        String errMsg = "나눗셈 연산시 두 번째 숫자는 0일 수 없습니다!!";
        if (secondNum != 0){
            double result = 0;
            switch (operator){
                case "plus":
                    result = firstNum+secondNum;
                    break;
                case "minus":
                    result = firstNum-secondNum;
                    break;
                case "multiply":
                    result = firstNum*secondNum;
                    break;
                case "divide":
                    result = firstNum/secondNum;
                    break;
            }
            System.out.println(result);
            mav.addObject("result",result);
            mav.setViewName("CalcResult");
        } else {
            mav.addObject("errMsg", errMsg);
            mav.setViewName("ErrorResult");
        }
        return mav;
    }
}
