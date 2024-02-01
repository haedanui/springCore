package com.nhnacademy.edu.springframework.sender.impl;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.domain.User;
import com.nhnacademy.edu.springframework.sender.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DoorayMessageSender implements MessageSender {


    @Value("${name}")String name;
    @Value("${text}")String text;
    DoorayHookSender doorayHookSender;

    @Autowired
    public DoorayMessageSender(DoorayHookSender doorayHookSender){
        this.doorayHookSender = doorayHookSender;
    }
    @Override
    public boolean sendMessage(User user, String message) {
        try {
            doorayHookSender.send(DoorayHook.builder().botName(user.getName()).text(user.getText()).build());
            return true;
        }catch(Throwable e){
            e.printStackTrace();
        }
        return false;
    }
}
