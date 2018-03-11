package com.jpa.repository;

import com.jpa.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for table chat
 * Created by Aesonne on 04.03.2018
 */
public interface ChatRepository extends JpaRepository<Chat, Long> {

    /**
     * Find chat by name. Used for demo-data creation
     * @param name nickname
     * @return chats's data
     */
    Chat findByName(String name);

}
