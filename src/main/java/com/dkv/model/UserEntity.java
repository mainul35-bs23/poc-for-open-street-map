package com.dkv.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String username;

    public UserEntity(String username) {
        this.username = username;
    }
}
