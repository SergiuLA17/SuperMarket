package com.exemple.supermarket.controllers;

import com.exemple.supermarket.models.request.CheckQuantityOfProductRequest;
import com.exemple.supermarket.models.request.MultiProductRequest;
import com.exemple.supermarket.models.request.RefundRequest;
import com.exemple.supermarket.models.request.SingleProductRequest;
import com.exemple.supermarket.models.response.CheckQuantityResponse;
import com.exemple.supermarket.models.response.MultiProductsResponse;
import com.exemple.supermarket.models.response.RefundResponse;
import com.exemple.supermarket.models.response.SingleProductResponse;
import com.exemple.supermarket.service.SupermarketService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "Super Market")
public class MainController {
    @Autowired
    private SupermarketService service;

    @PostMapping("/buySingleProduct")
    @ResponseBody
    public ResponseEntity<SingleProductResponse> buySingleProduct(@RequestBody(required = false) SingleProductRequest request) {
        return service.buySingleProduct(request);
    }

    @PostMapping("/buyMultipleProducts")
    @ResponseBody
    public ResponseEntity<MultiProductsResponse> buyMultipleProducts(@RequestBody MultiProductRequest request) {
        return service.buyMultiProducts(request);
    }

    @PostMapping("/checkProductQuantity")
    @ResponseBody
    public ResponseEntity<CheckQuantityResponse> checkProductQuantity(@RequestBody(required = false) CheckQuantityOfProductRequest request) {
        return service.checkQuantity(request);
    }

    @PostMapping("/refundProduct")
    @ResponseBody
    public ResponseEntity<RefundResponse> returnProduct(@RequestBody RefundRequest refund) {
        return service.returnProduct(refund);
    }

}