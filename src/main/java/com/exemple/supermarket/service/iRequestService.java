package com.exemple.supermarket.service;

import com.exemple.supermarket.models.request.SingleProductRequest;
import org.springframework.http.ResponseEntity;

public interface iRequestService {
    ResponseEntity<String> send(String url, SingleProductRequest request);
}
