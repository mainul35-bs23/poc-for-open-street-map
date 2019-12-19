package com.dkv.model;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class UserEntity {
    private Long id;
    private String username;
}
