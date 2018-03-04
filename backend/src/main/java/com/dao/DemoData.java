package com.dao;

import com.Application;
import com.entity.User;
import org.slf4j.Logger;

/**
 * Class with demo data for app
 * Created by Aesonne on 04.03.2018
 */
public class DemoData {

    /**
     * Initialize database
     * @param log logger
     */
    public static void init(Logger log) {

        // save some registered users
        Application.userRepository.save(new User("Hulk"));
        Application.userRepository.save(new User("Deadpool"));
        Application.userRepository.save(new User("Flash"));
        Application.userRepository.save(new User("Batman"));
        Application.userRepository.save(new User("Catwoman"));

    }

}
