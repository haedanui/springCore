package com.nhnacademy.edu.springframework.service;

import com.nhnacademy.edu.springframework.domain.User;
import com.nhnacademy.edu.springframework.sender.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MessageSendService {

    MessageSender messageSender;


    @Autowired
    public MessageSendService(@Qualifier("doorayMessageSender") MessageSender messageSender){
        this.messageSender = messageSender;
    }

    public boolean doSendMessage(User user, String message){
        return messageSender.sendMessage(user, message);
    }

}
