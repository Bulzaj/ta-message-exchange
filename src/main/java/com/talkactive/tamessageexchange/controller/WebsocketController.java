package com.talkactive.tamessageexchange.controller;

import com.talkactive.tamessageexchange.model.MessageDTO;
import com.talkactive.tamessageexchange.service.MessagesExchangeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;


@Slf4j
@Controller
public class WebsocketController {

    private final MessagesExchangeService messagesExchangeService;

    public WebsocketController(MessagesExchangeService messagesExchangeService) {
        this.messagesExchangeService = messagesExchangeService;
    }

    @MessageMapping("/send")
    public void sendMessage(@Payload MessageDTO message, SimpMessageHeaderAccessor accessor) {
        String accessToken = accessor.getNativeHeader("accessToken").get(0);
        messagesExchangeService.sendMessage(message, accessToken);
    }
}