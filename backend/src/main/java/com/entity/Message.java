package com.entity;

import javax.persistence.*;

/**
 * Message data entity
 * Created by Aesonne on 05.03.2018
 */
@Entity
@Table(name="message")
public class Message {

    /**
     * Identifier
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    /**
     * Identifier of message's chat
     */
    private Long chatId;

    /**
     * Identifier of message's sender
     */
    private Long senderId;

    /**
     * Text of message
     */
    private String text;

    /**
     * Time when message was send
     * todo: find out what we want from this time
     */
    private String time;

    /**
     * Constructor for JPA only
     */
    protected Message() {}

    public Message(Long chatId, Long senderId, String text, String time) {
        this.chatId = chatId;
        this.senderId = senderId;
        this.text = text;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}