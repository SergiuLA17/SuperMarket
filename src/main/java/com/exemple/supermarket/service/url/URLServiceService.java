package com.exemple.supermarket.service.url;

import org.springframework.stereotype.Component;

@Component
public class URLServiceService implements iURLService {
    @Override
    public String singleProduct() {
        return "http://localhost:7777/getProduct";
    }

    public String refund() {
        return "http://localhost:7777/returnProduct";
    }

    public String checkQuantity() {
        return "http://localhost:7777/getQuantity";
    }

    public String multiProducts() {
        return "http://localhost:7777/getMultipleProducts";
    }

}
