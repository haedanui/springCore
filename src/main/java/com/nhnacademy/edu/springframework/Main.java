package com.nhnacademy.edu.springframework;


import com.nhnacademy.edu.springframework.domain.User;
import com.nhnacademy.edu.springframework.service.MessageSendService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        String TEST_MESSAGE = "테스트용 내용입니다.";
        User user = new User(
                "유승진",
                TEST_MESSAGE
        );
        try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")){
            MessageSendService messageSendService = context.getBean("messageSendService", MessageSendService.class);
            messageSendService.doSendMessage(user, TEST_MESSAGE);
        }
    }
}