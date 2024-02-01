package com.nhnacademy.edu.springframework.domain;

import lombok.Getter;

@Getter
public class User {
    String name;
    String text;

    public User(String name, String text){
        this.name = name;
        this.text = text;
    }
}
