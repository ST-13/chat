package com.entity;

import javax.persistence.*;

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
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    /**
     * Chat name
     */
    private String name;

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
}