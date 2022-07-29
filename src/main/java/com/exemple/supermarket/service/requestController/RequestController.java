package com.exemple.supermarket.service.requestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Component
public class RequestController implements iRequestController{
    @Autowired
    private CustomeRestTemplate customeRestTemplate;
    @Override
    public ResponseEntity<String> send(String url) {
        return customeRestTemplate.create().getForEntity(url, String.class);
    }
}
