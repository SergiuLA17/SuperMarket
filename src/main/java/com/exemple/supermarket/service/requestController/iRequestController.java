package com.exemple.supermarket.service.requestController;

import org.springframework.http.ResponseEntity;

public interface iRequestController {
    ResponseEntity<String> send(String url);
}
