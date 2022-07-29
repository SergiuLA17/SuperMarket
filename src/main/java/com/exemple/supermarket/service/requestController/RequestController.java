package com.exemple.supermarket.service.requestController;

import com.exemple.supermarket.request.Request;
import com.exemple.supermarket.request.RequestRefund;
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


    public ResponseEntity<String> send(String url, Request request) {
        return customeRestTemplate.create().postForEntity(url, request, String.class);
    }

    public ResponseEntity<String> send(String url, RequestRefund refund) {
        return customeRestTemplate.create().postForEntity(url, refund, String.class);
    }
}
