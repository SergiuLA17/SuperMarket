package com.exemple.supermarket.service.responseController;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface iResponse {
    void create(ResponseEntity<String> response);
}
