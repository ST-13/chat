package com.rest;

import com.Application;
import com.entity.Chat;
import com.entity.ChatUserRelation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Rest-service for Chat entity
 * Created by Aesonne on 04.03.2018
 */
@RestController
public class ChatController {

    /**
     * Service for getting list of user's chats
     * @return list of user's chats
     */
    @CrossOrigin(origins = "http://127.0.0.1:8000")
    @RequestMapping("/chats")
    public List<Chat> getUserChats(@RequestParam(value="userId") Long userId) {
        List<ChatUserRelation> chatToUserRelations = Application.chatToUserRepository.findByUserId(userId);
        List<Chat> chats = new ArrayList<>();
        chatToUserRelations.forEach(chatToUserRelation ->
            chats.add(Application.chatRepository.findOne(chatToUserRelation.getChatId()))
        );
        return chats;
    }

    /**
     * Service for getting data about chat
     * @return chat's data
     */
    @CrossOrigin(origins = "http://127.0.0.1:8000")
    @RequestMapping("/chat")
    public Chat getChatData(@RequestParam(value="id") Long id) {
        return Application.chatRepository.findOne(id);
    }

}
