package com.jpa.repository;

import com.jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for table user
 * Created by Aesonne on 04.03.2018
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Find user by nickname
     * @param nickname nickname
     * @return user's data
     */
    User findByNickname(String nickname);

}
