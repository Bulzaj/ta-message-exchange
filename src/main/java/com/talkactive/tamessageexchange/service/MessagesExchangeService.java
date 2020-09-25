package com.talkactive.tamessageexchange.service;

import com.talkactive.tamessageexchange.model.MessageDTO;
import org.springframework.stereotype.Service;

@Service
public interface MessagesExchangeService {

    void sendMessage(MessageDTO messageDTO, String accessToken);
}