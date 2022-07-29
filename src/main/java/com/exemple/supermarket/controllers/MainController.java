package com.exemple.supermarket.controllers;

import com.exemple.supermarket.models.request.CheckQuantityOfProductRequest;
import com.exemple.supermarket.models.request.MultiProductRequest;
import com.exemple.supermarket.models.request.RefundRequest;
import com.exemple.supermarket.models.request.SingleProductRequest;
import com.exemple.supermarket.service.SupermarketService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(description = "Super Market")
public class MainController {
    @Autowired
    private SupermarketService service;

    @PostMapping("/buySingleProduct")
    @ResponseBody
    public ResponseEntity<?> buySingleProduct(@RequestBody(required = false) SingleProductRequest request) {
        service.buySingleProduct(request);
        return service.response();
    }

    @PostMapping("/buyMultipleProducts")
    @ResponseBody
    public ResponseEntity<?> buyMultipleProducts(@RequestBody MultiProductRequest request) {
        service.buyMultiProducts(request);
        return service.response();
    }

    @PostMapping("/checkProductQuantity")
    @ResponseBody
    public ResponseEntity<?> checkProductQuantity(@RequestBody(required = false) CheckQuantityOfProductRequest request) {
        service.checkQuantity(request);
        return service.response();
    }

    @PostMapping("/refundProduct")
    @ResponseBody
    public ResponseEntity<?> returnProduct(@RequestBody RefundRequest refund) {
        service.returnProduct(refund);
        return service.response();
    }

}