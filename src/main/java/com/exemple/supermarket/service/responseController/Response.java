package com.exemple.supermarket.service.responseController;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class Response implements iResponse{
    private  ResponseEntity<String> response;

    public void create(ResponseEntity<String> response) {
        this.response = response;
    }
}
