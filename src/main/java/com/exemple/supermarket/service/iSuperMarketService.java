package com.exemple.supermarket.service;

import com.exemple.supermarket.model.Product;
import com.exemple.supermarket.request.Request;
import com.exemple.supermarket.request.RequestRefund;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import java.util.UUID;

public interface iSuperMarketService {
    ResponseEntity<String> buy(UUID id, String name, String quantity);

    Optional<Product> getProductFromRequest(JsonNode jsonNode);

    Optional<JsonNode> response(Optional<ResponseEntity<String>> response);

    ResponseEntity<String> buyMultiProducts(Request request);

    ResponseEntity<String> refund(RequestRefund refund);

    ResponseEntity<String> checkQuantity(UUID id, String name);

}
