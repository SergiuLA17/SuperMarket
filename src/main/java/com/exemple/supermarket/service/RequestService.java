package com.exemple.supermarket.service;

import com.exemple.supermarket.models.request.CheckQuantityOfProductRequest;
import com.exemple.supermarket.models.request.MultiProductRequest;
import com.exemple.supermarket.models.request.RefundRequest;
import com.exemple.supermarket.models.request.SingleProductRequest;
import com.exemple.supermarket.service.requestService.CustomeRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RequestService {
    @Autowired
    private CustomeRestTemplate customeRestTemplate;

    public ResponseEntity<String> singleProductRequest(String url, SingleProductRequest request) {
        return customeRestTemplate.create().postForEntity(url, request, String.class);
    }


    public ResponseEntity<String> checkQuantityOfProductRequest(String url, CheckQuantityOfProductRequest request) {
        return customeRestTemplate.create().postForEntity(url, request, String.class);
    }

    public ResponseEntity<String> refundProductRequest(String url, RefundRequest request) {
        return customeRestTemplate.create().postForEntity(url, request, String.class);
    }

    public ResponseEntity<String> multiProductRequest(String url, MultiProductRequest request) {
        return customeRestTemplate.create().postForEntity(url, request, String.class);
    }
}
