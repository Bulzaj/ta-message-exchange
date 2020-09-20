package com.talkactive.tamessageexchange.model;


public class MessageDTO {
    private String messageBody;
    private MessageType messageType;
    private String senderName;
    private String receiverName;
    private Long createdAt;

    public MessageDTO(String messageBody, MessageType messageType, String senderName, String receiverName, Long createdAt) {
        this.messageBody = messageBody;
        this.messageType = messageType;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.createdAt = createdAt;
    }

    public MessageDTO() {
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }
}
