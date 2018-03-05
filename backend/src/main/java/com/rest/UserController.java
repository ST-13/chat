package com.rest;

import com.Application;
import com.entity.ChatUserRelation;
import com.entity.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Rest-service for Client entity
 * Created by Aesonne on 04.03.2018
 */
@RestController
public class UserController {

    /**
     * Login service for getting info for the user
     * @return user's data
     */
    @CrossOrigin(origins = "http://127.0.0.1:8000")
    @RequestMapping("/login")
    public User login(@RequestParam(value="nickname") String nickname) {
        return Application.userRepository.findByNickname(nickname);
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
        if (Application.userRepository.findByNickname(nickname) != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Application.userRepository.save(user);
        // add user to chat for demo only
        Application.chatToUserRepository.save(new ChatUserRelation(
                Application.chatRepository.findByName("All hero chat").getId(),
                Application.userRepository.findByNickname(nickname).getId()));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}