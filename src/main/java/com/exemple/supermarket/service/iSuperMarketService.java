package com.exemple.supermarket.service;

import com.exemple.supermarket.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface iSuperMarketService {
    ResponseEntity<String> sendRequestToStorehouse(String name, String quantity);

    Optional<JsonNode> getResponseFromStorehouse(ResponseEntity<String> response) throws JsonProcessingException;

    Optional<Product> getProductFromRequest(JsonNode jsonNode);

}
