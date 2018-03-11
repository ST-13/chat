package com.jpa.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Nickname and login
     */
    @Column(unique = true)
    private String nickname;

    /**
     * User's chats
     */
    @ManyToMany(cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "users")
    private Set<Chat> chats = new HashSet<>();

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

    public Set<Chat> getChats() {
        return chats;
    }

    public void setChats(Set<Chat> chats) {
        this.chats = chats;
    }

}
