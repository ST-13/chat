package com.rest;

import com.Application;
import com.jpa.model.Chat;
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
     * todo: delete method after rewriting frontend
     */
    @CrossOrigin(origins = "http://127.0.0.1:8000")
    @RequestMapping("/chats")
    @Deprecated
    public List<Chat> getUserChats(@RequestParam(value="userId") Long userId) {
        List<Chat> chats = new ArrayList<>(Application.userRepository.findOne(userId).getChats());
        chats.forEach(chat -> chat.setUsers(null));
        return chats;
    }

    /**
     * Service for getting data about chat
     * @return chat's data
     */
    @CrossOrigin(origins = "http://127.0.0.1:8000")
    @RequestMapping("/chat")
    public Chat getChatData(@RequestParam(value="id") Long id) {
        Chat chat = Application.chatRepository.findOne(id);
        chat.getUsers().forEach(user -> user.setChats(null));
        return chat;
    }

}
