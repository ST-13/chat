package com.dao;

import com.entity.ChatUserRelation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Repository for table chat_to_user
 * Created by Aesonne on 04.03.2018
 */
public interface ChatToUserRepository extends CrudRepository<ChatUserRelation, Long> {

    /**
     * Find all user to chat relations with the user
     * @param userId user's identifier
     * @return list of user's chat
     */
    List<ChatUserRelation> findByUserId(Long userId);

}
