package com.exemple.supermarket.service.url;

import org.springframework.stereotype.Component;

@Component
public class CustomURL implements iCustomURL {
    @Override
    public String StorehouseURL(String name, String quantity) {
        return "http://localhost:8100/getProduct?name=" + name + "&quantity=" + quantity;
    }
}
