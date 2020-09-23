package com.talkactive.tamessageexchange.service;

import com.talkactive.tamessageexchange.httpClient.ConversationServiceFeignClient;
import com.talkactive.tamessageexchange.model.MessageDTO;
import com.talkactive.tamessageexchange.model.MessageType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageExchangeServiceImpl implements MessagesExchangeService {

    private final ConversationServiceFeignClient feignClient;
    private final SimpMessagingTemplate template;

    public MessageExchangeServiceImpl(ConversationServiceFeignClient feignClient, SimpMessagingTemplate template) {
        this.feignClient = feignClient;
        this.template = template;
    }

    @Override
    public void sendMessage(MessageDTO messageDTO, String accessToken) {
        log.info(accessToken);
        if (messageDTO.getMessageType().toString().equals(MessageType.NORMAL.toString())) {
            if (accessToken != null && !accessToken.isEmpty()) {
                feignClient.saveMessage("Bearer " + accessToken, messageDTO);
                template.convertAndSend("/queue/reply/"+messageDTO.getSenderName(), messageDTO);
                template.convertAndSend("/queue/reply/"+messageDTO.getReceiverName(), messageDTO);
            } else throw new IllegalStateException("Access token could not be null or empty");
        } else {
            template.convertAndSend("/queue/reply/"+messageDTO.getSenderName(), messageDTO);
            template.convertAndSend("/queue/reply/"+messageDTO.getReceiverName(), messageDTO);
        }
    }
}
