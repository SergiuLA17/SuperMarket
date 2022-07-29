package com.exemple.supermarket.model;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Component
public class ProductController implements iProductController {
    @Autowired
    private Product product;

    public Optional<Product> returnProduct(JsonNode jsonNode){
        try {
            product.setName(String.valueOf(jsonNode.get("name")));
            product.setQuantity(Integer.parseInt(String.valueOf(jsonNode.get("quantity"))));
            product.setDaysToExpire(Integer.parseInt(String.valueOf(jsonNode.get("quantity"))));
            product.setDateOfManufacture(LocalDateTime.parse(jsonNode.get("dateOfManufacture").asText()));
        } catch (Exception ignored) {
            System.out.println(jsonNode.get("dateOfManufacture") + " " + product.getDateOfManufacture());

        }
        return Optional.of(product);
    }
}
