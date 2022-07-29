package com.exemple.supermarket.service.url;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CustomURL implements iCustomURL {
    @Override
    public String singleProduct(UUID id,String name, String quantity) {
        return "http://localhost:8100/getProduct?idRequest=" + id + "&name=" + name + "&quantity=" + quantity;
    }

    public String checkQuantity(UUID id,String name) {
        return "http://localhost:8100/getQuantity?idRequest=" + id + "&name=" + name;
    }

    public String multiProducts() {
        return "http://localhost:8100/getMultipleProducts";
    }

    public String refund() {
        return "http://localhost:8100/returnProduct";
    }
}
