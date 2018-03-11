package com.jpa;

import com.jpa.model.Chat;
import com.jpa.model.Message;
import com.jpa.model.User;
import com.jpa.repository.ChatRepository;
import com.jpa.repository.MessageRepository;
import com.jpa.repository.UserRepository;
import org.slf4j.Logger;

/**
 * Class with demo data for app
 * Created by Aesonne on 04.03.2018
 */
public class DemoDataInitializer {

    /**
     * User's repository
     */
    private final UserRepository userRepository;

    /**
     * Chat's repository
     */
    private final ChatRepository chatRepository;

    /**
     * Messages's repository
     */
    private final MessageRepository messageRepository;

    /**
     * Constructor with repositories injection
     * @param userRepository    user's repository
     * @param chatRepository    chat's repository
     * @param messageRepository messages's repository
     */
    public DemoDataInitializer(UserRepository userRepository, ChatRepository chatRepository,
                               MessageRepository messageRepository){
        this.userRepository = userRepository;
        this.chatRepository = chatRepository;
        this.messageRepository = messageRepository;
    }

    /**
     * Initialize database
     * @param log logger
     */
    public void init(Logger log) {

        log.info("Creating demo data");

        // heroes
        User hulk = new User("Hulk");
        User deadpool = new User("Deadpool");
        User flash = new User("Flash");
        User batman = new User("Batman");
        User catwoman = new User("Catwoman");

        // chats
        Chat allHeroChat = new Chat("All hero chat");
        Chat badGuysChat = new Chat("Private bad guys chat");

        // add all heroes to all heroes chat
        hulk.getChats().add(allHeroChat);
        deadpool.getChats().add(allHeroChat);
        flash.getChats().add(allHeroChat);
        batman.getChats().add(allHeroChat);
        catwoman.getChats().add(allHeroChat);
        allHeroChat.getUsers().add(hulk);
        allHeroChat.getUsers().add(deadpool);
        allHeroChat.getUsers().add(flash);
        allHeroChat.getUsers().add(batman);
        allHeroChat.getUsers().add(catwoman);

        // add some heroes to bad guys chat
        deadpool.getChats().add(badGuysChat);
        batman.getChats().add(badGuysChat);
        badGuysChat.getUsers().add(deadpool);
        badGuysChat.getUsers().add(batman);

        log.info("Created demo data successfully. Saving demo started");

        // save some registered users
        userRepository.save(hulk);
        userRepository.save(deadpool);
        userRepository.save(flash);
        userRepository.save(batman);
        userRepository.save(catwoman);

        // save some active chats
        chatRepository.save(allHeroChat);
        chatRepository.save(badGuysChat);

        // save some sent messages
        Long hero1id = userRepository.findByNickname("Deadpool").getId();
        Long hero2id = userRepository.findByNickname("Flash").getId();
        Long hero3id = userRepository.findByNickname("Batman").getId();
        Long chat0id = chatRepository.findByName("All hero chat").getId();
        Long chat1id = chatRepository.findByName("Private bad guys chat").getId();
        // add some old messages to active chats
        messageRepository.save(new Message(chat0id, hero2id, "Thank you!", "12.03.2018:11.06.55"));
        messageRepository.save(new Message(chat0id, hero3id, "Welcome to place we discuss our plans now",
                "12.03.2018:11.06.56"));

        messageRepository.save(new Message(chat1id, hero3id, "We are not like the others",
                "12.03.2018:11.10.45"));
        messageRepository.save(new Message(chat1id, hero1id, "There are no 'we'",
                "12.03.2018:11.10.45"));
    }

}
