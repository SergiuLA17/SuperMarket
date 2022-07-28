package com.exemple.supermarket.controllers;

import com.exemple.supermarket.exception.ProductNotfoundException;
import com.exemple.supermarket.service.SuperMarketService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
public class MainController {
    @Autowired
    SuperMarketService service;

    Logger logger = LoggerFactory.getLogger(MainController.class);
    private int count = 0;

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "/getProductFromStorehouse")
    public synchronized ResponseEntity sendRequestToStorehouse(@RequestParam("name") String name, @RequestParam("quantity") String quantity) throws InterruptedException, JsonProcessingException {
        count++;
        Thread.currentThread().setName("Buyer " + count);

        ResponseEntity<String> response = service.sendRequestToStorehouse(name, quantity);

        Thread.sleep(50 + (int) (Math.random() * 100));
            if (!(response.getStatusCode() == HttpStatus.OK)) {
                logger.info("Desired products " + Thread.currentThread().getName() + " not found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");

            } else
                logger.info("Product " + service.getResponseFromStorehouse(response).get() + "has been sent to " + Thread.currentThread().getName());
        return ResponseEntity.ok(service.getProductFromRequest(service.getResponseFromStorehouse(response).get()));
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "/1000purchases")
    public String send1000PurchasesRequest() {

        for (int i = 0; i < 1000; i++) {
            service.putRandomParamInRequest(i);
        }

        return "done";
    }
}