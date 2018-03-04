package com.dao;

import com.entity.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Repository for table message
 * Created by Aesonne on 05.03.2018
 */
public interface MessageRepository extends CrudRepository<Message, Long> {

    /**
     * Find all messages of chat
     * @param chatId chat's identifier
     * @return list of user's chat
     */
    List<Message> findByChatId(Long chatId);

}
