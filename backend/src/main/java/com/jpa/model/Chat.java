package com.jpa.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Chat data entity
 * Created by Aesonne on 04.03.2018
 */
@Entity
@Table(name="chat")
public class Chat {

    /**
     * Identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Chat name
     */
    private String name;

    /**
     * Chat's participants
     */
    @ManyToMany(cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "chat_users",
            joinColumns = { @JoinColumn(name = "chat_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") })
    private Set<User> users = new HashSet<>();

    /**
     * Constructor for JPA only
     */
    protected Chat() {}

    /**
     * Constructor with chat's data
     * @param name chat's name
     */
    public Chat(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}