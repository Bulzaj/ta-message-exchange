package com.talkactive.tamessageexchange.httpClient;

import com.talkactive.tamessageexchange.model.MessageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient("ta-conversation-storage")
public interface ConversationServiceFeignClient {

    @PostMapping("/api/conversation/save-message")
    MessageDTO saveMessage(@RequestHeader(value = "Authorization", required = true) String authHeader, @RequestBody MessageDTO messageDTO);
}
