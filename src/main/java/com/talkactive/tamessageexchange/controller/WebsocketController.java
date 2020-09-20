package com.talkactive.tamessageexchange.controller;

import com.talkactive.tamessageexchange.model.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;


@Slf4j
@Controller
public class WebsocketController {

    private final SimpMessagingTemplate template;

    public WebsocketController(SimpMessagingTemplate template) {
        this.template = template;
    }


    @MessageMapping("/send")
    public void sendMessage(@Payload MessageDTO message) {
        template.convertAndSend("/queue/reply/"+message.getSenderName(), message);
        template.convertAndSend("/queue/reply/"+message.getReceiverName(), message);
    }
}

