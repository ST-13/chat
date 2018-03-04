package com.dao;

import com.entity.Chat;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for table chat
 * Created by Aesonne on 04.03.2018
 */
public interface ChatRepository extends CrudRepository<Chat, Long> {

    /**
     * Find chat by name. Used for demo-data creation
     * @param name nickname
     * @return chats's data
     */
    Chat findByName(String name);

}
