package com.exemple.supermarket.supermarketHandler;

import com.exemple.supermarket.print.Print;
import com.exemple.supermarket.service.SuperMarketService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SupermarketHandler implements iSupermarketHandler {
    private ResponseEntity<String> response;
    @Autowired
    private SuperMarketService service;
    @Autowired
    private Print print;

    public void sendRequest(String name, String quantity){
        print.info("Request has been send: Product -> " + name + ", quantity -> " + quantity);
        response = service.sendRequestToStorehouse(name, quantity);;
    }

    public ResponseEntity getResponse() throws JsonProcessingException {
        if (!(response.getStatusCode() == HttpStatus.OK)) {
            print.info("Desired products not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");

        } else
            print.info("Product " + service.getResponseFromStorehouse(response).get() + "has been sent to buyer");

        return ResponseEntity.ok(service.getProductFromRequest(service.getResponseFromStorehouse(response).get()));
    }
}
