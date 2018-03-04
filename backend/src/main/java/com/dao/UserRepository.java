package com.dao;

import com.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for table user
 * Created by Aesonne on 04.03.2018
 */
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * Find user by nickname
     * @param nickname nickname
     * @return user's data
     */
    User findByNickname(String nickname);

}
