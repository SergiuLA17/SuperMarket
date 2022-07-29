package com.exemple.supermarket.service;

import com.exemple.supermarket.models.request.MultiProductRequest;
import com.exemple.supermarket.models.request.RefundRequest;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface iSupermarketService {
    void BuySingleProduct(UUID id, String name, String quantity);
    void CheckQuantity(UUID id, String name);
    void ReturnProduct(RefundRequest refund);
    void BuyMultiProducts(MultiProductRequest request);
    ResponseEntity<?> response();
}
