package com.example.springedu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.springedu.domain.ProductDTO;

@Controller
@SessionAttributes("p")
public class ProductController {
    @ModelAttribute("p")
    public ProductDTO create() {
        return new ProductDTO();
    }

    @GetMapping("/cart")  // 카트에 담을 때마다
    public String productCart(@ModelAttribute("p") ProductDTO pvo) {		 // ProductVO -> ProductDTO로 바꾸자
        return  "productView";  // 상품이 누적됨
    }

    @GetMapping("/buy")
    public String clearCart(SessionStatus session) {
        session.setComplete(); // 세션 객체에 보관된 것들을 다 없애 버림
        return  "productView";
    }
}




