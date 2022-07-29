package com.exemple.supermarket.service;

import com.exemple.supermarket.models.request.CheckQuantityOfProductRequest;
import com.exemple.supermarket.models.request.MultiProductRequest;
import com.exemple.supermarket.models.request.RefundRequest;
import com.exemple.supermarket.models.request.SingleProductRequest;
import com.exemple.supermarket.models.response.CheckQuantityResponse;
import com.exemple.supermarket.models.response.MultiProductsResponse;
import com.exemple.supermarket.models.response.RefundResponse;
import com.exemple.supermarket.models.response.SingleProductResponse;
import com.exemple.supermarket.service.restTemplate.CustomRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RequestService implements iRequestService {
    @Autowired
    private CustomRestTemplate customeRestTemplate;

    public ResponseEntity<SingleProductResponse> singleProductRequest(String url, SingleProductRequest request) {
        return customeRestTemplate.create().postForEntity(url, request, SingleProductResponse.class);
    }

    public ResponseEntity<CheckQuantityResponse> checkQuantityOfProductRequest(String url, CheckQuantityOfProductRequest request) {
        return customeRestTemplate.create().postForEntity(url, request, CheckQuantityResponse.class);
    }

    public ResponseEntity<RefundResponse> refundProductRequest(String url, RefundRequest request) {
        return customeRestTemplate.create().postForEntity(url, request, RefundResponse.class);
    }

    public ResponseEntity<MultiProductsResponse> multiProductRequest(String url, MultiProductRequest request) {
        return customeRestTemplate.create().postForEntity(url, request, MultiProductsResponse.class);
    }
}
