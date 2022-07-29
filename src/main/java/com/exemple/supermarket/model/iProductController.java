package com.exemple.supermarket.model;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Optional;

public interface iProductController {
    Optional<Product> returnProduct(JsonNode jsonNode);
}
