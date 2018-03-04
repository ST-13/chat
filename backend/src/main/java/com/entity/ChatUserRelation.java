package com.entity;

import javax.persistence.*;

/**
 * Relation chats to users entity
 * Created by Aesonne on 04.03.2018
 */
@Entity
@Table(name="chat_to_user")
public class ChatUserRelation {

    /**
     * Identifier
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    /**
     * Chat's identifier
     */
    private Long chatId;

    /**
     * User's identifier
     */
    private Long userId;

    /**
     * Constructor for JPA only
     */
    protected ChatUserRelation() {}

    /**
     * Constructor with relation's data
     * @param chatId chat's identifier
     * @param userId user's identifier
     */
    public ChatUserRelation(Long chatId, Long userId) {
        this.chatId = chatId;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}