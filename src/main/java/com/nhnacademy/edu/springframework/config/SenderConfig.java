package com.nhnacademy.edu.springframework.config;

import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.aop.Logging;
import com.nhnacademy.edu.springframework.sender.MessageSender;
import com.nhnacademy.edu.springframework.sender.impl.DoorayMessageSender;
import com.nhnacademy.edu.springframework.service.MessageSendService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;

@EnableAspectJAutoProxy
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.nhnacademy.edu.springframework")
public class SenderConfig {

//    @Bean
//    public DoorayMessageSender doorayMessageSender(DoorayHookSender doorayHookSender){
//        return new DoorayMessageSender(doorayHookSender);
//    }

//    @Bean
//    public MessageSendService messageSendService(MessageSender doorayMessageSender){
//        return new MessageSendService(doorayMessageSender);
//    }

//    @Bean
//    public Logging logging(){
//        return new Logging();
//    }

//    @Bean
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }
//
//    @Bean
//    public DoorayHookSender doorayHookSender(RestTemplate restTemplate, @Value("${hookUrl}") String hookUrl){
//        return new DoorayHookSender(restTemplate, hookUrl);
//    }
}
