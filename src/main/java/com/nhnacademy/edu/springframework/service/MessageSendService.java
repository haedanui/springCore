package com.nhnacademy.edu.springframework.service;

import com.nhnacademy.edu.springframework.annotation.Custom;
import com.nhnacademy.edu.springframework.domain.User;
import com.nhnacademy.edu.springframework.sender.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class MessageSendService {

    MessageSender messageSender;


    @Autowired
    public MessageSendService(@Custom MessageSender messageSender){
        this.messageSender = messageSender;
    }

    public boolean doSendMessage(User user, String message){
        return messageSender.sendMessage(user, message);
    }

}
