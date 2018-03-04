package com.dao;

import com.Application;
import com.entity.Chat;
import com.entity.ChatUserRelation;
import com.entity.Message;
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

        // save some active chats
        Application.chatRepository.save(new Chat("All hero chat"));
        Application.chatRepository.save(new Chat("Private bad guys chat"));

        // add some users into some chats
        Long hero0id = Application.userRepository.findByNickname("Hulk").getId();
        Long hero1id = Application.userRepository.findByNickname("Deadpool").getId();
        Long hero2id = Application.userRepository.findByNickname("Flash").getId();
        Long hero3id = Application.userRepository.findByNickname("Batman").getId();
        Long hero4id = Application.userRepository.findByNickname("Catwoman").getId();

        Long chat0id = Application.chatRepository.findByName("All hero chat").getId();
        Long chat1id = Application.chatRepository.findByName("Private bad guys chat").getId();

        Application.chatToUserRepository.save(new ChatUserRelation(chat0id, hero0id));
        Application.chatToUserRepository.save(new ChatUserRelation(chat0id, hero1id));
        Application.chatToUserRepository.save(new ChatUserRelation(chat0id, hero2id));
        Application.chatToUserRepository.save(new ChatUserRelation(chat0id, hero3id));
        Application.chatToUserRepository.save(new ChatUserRelation(chat0id, hero4id));

        Application.chatToUserRepository.save(new ChatUserRelation(chat1id, hero1id));
        Application.chatToUserRepository.save(new ChatUserRelation(chat1id, hero3id));

        // add some old messages to active chats
        Application.messageRepository.save(new Message(chat0id, hero2id, "Thank you!", "12.03.2018:11.06.55"));
        Application.messageRepository.save(new Message(chat0id, hero3id, "Welcome to place we discuss our plans now",
                "12.03.2018:11.06.56"));

        Application.messageRepository.save(new Message(chat1id, hero3id, "We are not like the others",
                "12.03.2018:11.10.45"));
        Application.messageRepository.save(new Message(chat1id, hero1id, "There are no 'we'",
                "12.03.2018:11.10.45"));
    }

}
