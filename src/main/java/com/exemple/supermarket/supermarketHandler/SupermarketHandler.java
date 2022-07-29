package com.exemple.supermarket.supermarketHandler;

import com.exemple.supermarket.print.Print;
import com.exemple.supermarket.request.Request;
import com.exemple.supermarket.request.RequestRefund;
import com.exemple.supermarket.service.SuperMarketService;
import com.exemple.supermarket.service.responseController.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class SupermarketHandler implements iSupermarketHandler {
    private ResponseEntity<String> storehouseResponse;
    @Autowired
    private SuperMarketService service;
    @Autowired
    private Print print;
    @Autowired
    private ResponseStatus responseStatus;

    public void BuySingleProduct(UUID id, String name, String quantity) {
        print.info("Request has been send " + "id: " + id + " " + ", product name:" + name + ", quantity: " + quantity);
        storehouseResponse = service.buy(id, name, quantity);
    }

    public void CheckQuantity(UUID id, String name) {
        print.info("Request has been send " + "id: " + id + " " + ", product name:" + name);
        storehouseResponse = service.checkQuantity(id, name);
    }

    public void ReturnProduct(RequestRefund refund) {
        print.info("Request has been send " + refund);
        storehouseResponse = service.refund(refund);
    }

    public void BuyMultiProducts(Request request) {
        print.info("Request has been send: Product -> " + request);
        storehouseResponse = service.buyMultiProducts(request);
    }

    public ResponseEntity<?> response() {
        responseStatus.check(Optional.ofNullable(storehouseResponse),service,print);
        return ResponseEntity.ok(storehouseResponse);
    }
}
