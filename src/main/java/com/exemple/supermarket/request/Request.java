package com.exemple.supermarket.request;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Request {
    protected UUID id;

    public Request() {

    }

    public UUID getId() {
        return id;
    }


    public void setId(UUID id) {
        this.id = id;
    }
}
