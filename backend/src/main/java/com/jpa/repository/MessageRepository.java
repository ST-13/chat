package com.jpa.repository;

import com.jpa.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository for table message
 * Created by Aesonne on 05.03.2018
 */
public interface MessageRepository extends JpaRepository<Message, Long> {

    /**
     * Find all messages of chat
     * @param chatId chat's identifier
     * @return list of user's chat
     */
    List<Message> findByChatId(Long chatId);

}
