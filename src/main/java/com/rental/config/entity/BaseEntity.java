package com.rental.config.entity;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;


import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    private String id;

    @PrePersist
    public void generateId(){
        if(id == null){
            id = UUID.randomUUID().toString();
        }
    }

    public String getId() {
        return id;
    }
}