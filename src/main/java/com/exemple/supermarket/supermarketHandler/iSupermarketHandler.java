package com.exemple.supermarket.supermarketHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

public interface iSupermarketHandler {
    void sendRequest(String name, String quantity);
    ResponseEntity getResponse() throws JsonProcessingException;
}
