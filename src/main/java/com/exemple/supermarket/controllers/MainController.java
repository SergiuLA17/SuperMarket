package com.exemple.supermarket.controllers;

import com.exemple.supermarket.request.RequestRefund;
import com.exemple.supermarket.request.RequestWIthProducts;
import com.exemple.supermarket.supermarketHandler.SupermarketHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;


@RestController
@Api(description = "Super Market")
public class MainController {
    @Autowired
    private SupermarketHandler handler;

    @GetMapping("/buySingleProduct")
    public ResponseEntity<?> buySingleProduct( @RequestParam("uuid") UUID uuid, @RequestParam("name") String name, @RequestParam("quantity") String quantity) throws JsonProcessingException {
        handler.BuySingleProduct(uuid,name, quantity);
        return handler.response();
    }

    @RequestMapping(value = "/buyMultipleProducts", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ResponseEntity<?> buyMultipleProducts(@RequestParam(required = false) RequestWIthProducts request) {
        handler.BuyMultiProducts(request);
        return handler.response();
    }

    @GetMapping("/checkProductQuantity")
    public ResponseEntity<?> checkProductQuantity( @RequestParam("name") String name,@RequestParam("name") UUID uuid) {
        handler.CheckQuantity(uuid,name);
        return handler.response();
    }

    @RequestMapping(value = "/returnProduct", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ResponseEntity<?> returnProduct(RequestRefund refund) {
        handler.ReturnProduct(refund);
        return handler.response();
    }

}