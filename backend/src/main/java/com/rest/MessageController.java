package com.rest;

import com.Application;
import com.entity.Message;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest-service for Message entity
 * Created by Aesonne on 05.03.2018
 */
@RestController
public class MessageController {

    /**
     * Service for getting list of chat's messages
     * @return list of chat's messages
     */
    @RequestMapping("/messages")
    public List<Message> getUserChats(@RequestParam(value="chatId") Long chatId) {
        return Application.messageRepository.findByChatId(chatId);
    }

}
