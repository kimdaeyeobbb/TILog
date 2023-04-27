package com.example.springedu.domain;

import lombok.Data;

@Data
public class BookDTO {
    private int id;
    private String title;
    private String price;
    private String kind;
}
