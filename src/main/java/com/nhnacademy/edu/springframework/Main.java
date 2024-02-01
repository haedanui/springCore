package com.nhnacademy.edu.springframework;


import com.nhnacademy.edu.springframework.config.SenderConfig;
import com.nhnacademy.edu.springframework.domain.User;
import com.nhnacademy.edu.springframework.service.MessageSendService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        String TEST_MESSAGE = "테스트용 내용입니다.";
        User user = new User(
                "유승진",
                TEST_MESSAGE
        );

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SenderConfig.class);
        context.getBean("messageSendService", MessageSendService.class).doSendMessage(user, "테스트입니다.");
    }
}