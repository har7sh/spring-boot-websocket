package com.shcode.spring.boot.websocket.controller;

import com.shcode.spring.boot.websocket.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @MessageMapping("/message.register")
    @SendTo("/topic/public")
    public Message register(@Payload Message message, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", message.getSender());
        return message;
    }

    @MessageMapping("/message.send")
    @SendTo("/topic/public")
    public Message sendMessage(@Payload Message message) {
        return message;
    }
}
