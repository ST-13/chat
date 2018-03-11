package com.rest;

import com.jpa.model.Chat;
import com.jpa.model.User;

import com.jpa.repository.ChatRepository;
import com.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Rest-service for Client entity
 * Created by Aesonne on 04.03.2018
 */
@RestController
public class UserController {

    /**
     * User's repository
     */
    private final UserRepository userRepository;

    /**
     * Chat's repository
     */
    private final ChatRepository chatRepository;

    /**
     * Constructor with repositories injection
     * @param userRepository user's repository
     * @param chatRepository chat's repository
     */
    @Autowired
    public UserController(UserRepository userRepository, ChatRepository chatRepository) {
        this.userRepository = userRepository;
        this.chatRepository = chatRepository;
    }

    /**
     * Login service for getting info for the user
     * @return user's data
     * todo: change service interface to return error in correct way
     */
    @CrossOrigin(origins = "http://127.0.0.1:8000")
    @RequestMapping("/login")
    public User login(@RequestParam(value="nickname") String nickname) {
        User user = userRepository.findByNickname(nickname);
        if (user == null) {
            return null;
        }
        user.getChats().forEach(chat -> chat.setUsers(null));
        return user;
    }

    /**
     * Simple user registration with saving user into base.
     * Return error(400) if user exist
     * @param user new user for registration
     * @return response with user data
     * todo: remove adding new user to default chat after creation functionality adding users to chat
     */
    @CrossOrigin(origins = "http://127.0.0.1:8000")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<User> register(@RequestBody User user) {
        String nickname = user.getNickname();
        if (userRepository.findByNickname(nickname) != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        // add user to chat for demo only
        Chat allHeroChat = chatRepository.findByName("All hero chat");
        allHeroChat.getUsers().add(user);
        Set<Chat> defaultChats = new HashSet<>();
        defaultChats.add(allHeroChat);
        user.setChats(defaultChats);
        userRepository.save(user);
        chatRepository.save(allHeroChat);
        user.getChats().forEach(chat -> chat.setUsers(null));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}