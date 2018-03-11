package com;

import com.jpa.*;
import com.jpa.repository.ChatRepository;
import com.jpa.repository.MessageRepository;
import com.jpa.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Spring configuration
 * Created by Aesonne on 04.03.2018
 */
@SpringBootApplication
public class Application {

    /**
     * Logger
     */
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    /**
     * App initialization
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * DataBase initializer
     * @param userRepository    user's repository
     * @param chatRepository    chat's repository
     * @param messageRepository messages's repository
     * @return runner for Spring Boot
     */
    @Bean
    public CommandLineRunner initDemoData(UserRepository userRepository, ChatRepository chatRepository,
                                  MessageRepository messageRepository) {
        log.info("App initialization started");
        return (args) -> {
            log.info("Repositories initialized");
            new DemoDataInitializer(userRepository, chatRepository, messageRepository).init(log);
            log.info("Demo data uploaded");
        };
    }
}