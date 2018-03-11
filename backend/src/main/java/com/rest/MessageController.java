package com.rest;

import com.Application;
import com.jpa.model.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @CrossOrigin(origins = "http://127.0.0.1:8000")
    @RequestMapping("/messages")
    public List<Message> getUserChats(@RequestParam(value="chatId") Long chatId) {
        return Application.messageRepository.findByChatId(chatId);
    }

    /**
     * Sending message: save it to base
     * @param message message
     * @return response with message
     */
    @CrossOrigin(origins = "http://127.0.0.1:8000")
    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public ResponseEntity<Message> sendMessage(@RequestBody Message message) {
        Application.messageRepository.save(message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
