package com.rest;

import com.jpa.model.Chat;
import com.jpa.repository.ChatRepository;
import com.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
     * Chat's repository
     */
    private final ChatRepository chatRepository;

    /**
     * User's repository
     */
    private final UserRepository userRepository;

    /**
     * Constructor with repositories injection
     * @param userRepository user's repository
     * @param chatRepository chat's repository
     */
    @Autowired
    public ChatController(UserRepository userRepository, ChatRepository chatRepository) {
        this.userRepository = userRepository;
        this.chatRepository = chatRepository;
    }

    /**
     * Service for getting list of user's chats
     * @return list of user's chats
     * todo: delete method after rewriting frontend
     */
    @CrossOrigin(origins = "http://127.0.0.1:8000")
    @RequestMapping("/chats")
    @Deprecated
    public List<Chat> getUserChats(@RequestParam(value="userId") Long userId) {
        List<Chat> chats = new ArrayList<>(userRepository.findOne(userId).getChats());
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
        Chat chat = chatRepository.findOne(id);
        if (chat == null) {
            return null;
        }
        chat.getUsers().forEach(user -> user.setChats(null));
        return chat;
    }

}
