package com.nhnacademy.edu.springframework.config;

import com.nhn.dooray.client.DoorayHookSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;

@EnableAspectJAutoProxy
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.nhnacademy.edu.springframework")
public class SenderConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public DoorayHookSender doorayHookSender(RestTemplate restTemplate, @Value("${hookUrl}") String hookUrl){
        return new DoorayHookSender(restTemplate, hookUrl);
    }
}
