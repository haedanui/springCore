package com.nhnacademy.edu.springframework;


import com.nhnacademy.edu.springframework.domain.User;
import com.nhnacademy.edu.springframework.service.MessageSendService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        String TEST_MESSAGE = "테스트용 내용입니다.";
        User user = new User(
                "rhs9705kr@naver.com",
                "010-1234-5678"
        );
        try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")){
            context.getBean("messageSendService", MessageSendService.class).doSendMessage(user, TEST_MESSAGE);
        }
    }
}