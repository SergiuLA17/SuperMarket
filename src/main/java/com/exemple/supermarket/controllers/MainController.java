package com.exemple.supermarket.controllers;

import com.exemple.supermarket.supermarketHandler.SupermarketHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/exemples")
@Api(description = "Super Market")
public class MainController {
    @Autowired
    SupermarketHandler handler;

    @GetMapping("/")
    @RequestMapping(method = {RequestMethod.GET}, value = "/getProductFromStorehouse")
    public synchronized ResponseEntity sendRequestToStorehouse(@RequestParam("name") String name, @RequestParam("quantity") String quantity) throws JsonProcessingException {
        handler.sendRequest(name, quantity);
        return handler.getResponse();
    }
}