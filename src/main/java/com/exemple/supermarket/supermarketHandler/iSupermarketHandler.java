package com.exemple.supermarket.supermarketHandler;

import com.exemple.supermarket.request.Request;
import com.exemple.supermarket.request.RequestRefund;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface iSupermarketHandler {
    void BuySingleProduct(UUID id, String name, String quantity);
    void CheckQuantity(UUID id, String name);
    void ReturnProduct(RequestRefund refund);
    void BuyMultiProducts(Request request);
    ResponseEntity<?> response();
}
