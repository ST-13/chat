package com.rest;

import com.Application;
import com.entity.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping("/login")
    public User login(@RequestParam(value="nickname") String nickname) {
        return Application.userRepository.findByNickname(nickname);
    }

}