package com.entity;

import javax.persistence.*;

/**
 * User data entity
 * Created by Aesonne on 04.03.2018
 */
@Entity
@Table(name="user")
public class User {

    /**
     * Identifier
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    /**
     * Nickname and login
     */
    private String nickname;

    /**
     * Constructor for JPA only
     */
    protected User() {}

    /**
     * Constructor with user's data
     * @param nickname user's nickname
     */
    public User(String nickname) {
        this.nickname = nickname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
