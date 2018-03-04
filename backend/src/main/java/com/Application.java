package com;

import com.dao.DemoData;
import com.dao.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Spring configuration for web services
 * Created by Aesonne on 04.03.2018
 */
@SpringBootApplication
public class Application {

    /**
     * Logger
     */
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    /**
     * User's repository
     */
    public static UserRepository userRepository;

    /**
     * App initialization
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * DataBase initializer
     * @param userRepository repository for user from Spring's context
     * @return runner for Spring Boot
     */
    @Bean
    public CommandLineRunner demo(UserRepository userRepository) {
        log.info("App initialization started");
        return (args) -> {
            Application.userRepository = userRepository;
            log.info("Repositories initialized");
            DemoData.init(log);
            log.info("Demo data uploaded");
        };
    }
}