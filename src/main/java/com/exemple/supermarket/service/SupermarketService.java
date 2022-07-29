package com.exemple.supermarket.service;

import com.exemple.supermarket.models.request.RefundRequest;
import com.exemple.supermarket.service.logger.LoggerService;
import com.exemple.supermarket.models.request.CheckQuantityOfProductRequest;
import com.exemple.supermarket.models.request.MultiProductRequest;
import com.exemple.supermarket.models.request.SingleProductRequest;
import com.exemple.supermarket.service.url.URLServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SupermarketService {
    private ResponseEntity<String> storehouseResponse;
    @Autowired
    private RequestService service;
    @Autowired
    private LoggerService print;
    @Autowired
    private URLServiceService url;

    public void buySingleProduct(SingleProductRequest request) {
        print.info("Request has been send "
                + "id: " + request.getRequestUUID()
                +  " , product name: " + request.getProductName()
                + " , quantity: "
                + request.getProductQuantity());
        storehouseResponse = service.singleProductRequest(url.singleProduct(),request);
    }

    public void checkQuantity(CheckQuantityOfProductRequest request) {
        print.info("Request has been send "
                + "id: " + request.getRequestUUID() + " , product name: "
                + request.getNameOfProduct());
        storehouseResponse = service.checkQuantityOfProductRequest(url.checkQuantity(), request);
    }

    public void returnProduct(RefundRequest request) {
        print.info("Request has been send " + request);
        storehouseResponse = service.refundProductRequest(url.refund(), request);
    }

    public void buyMultiProducts(MultiProductRequest request) {
        print.info("Request has been send: Product -> " + request);
        storehouseResponse = service.multiProductRequest(url.multiProducts(), request);
    }

    public ResponseEntity<?> response() {
        print.info("The request having been granted");
        print.info("Response = " + storehouseResponse.getBody() + " has been sent to buyer");
        return ResponseEntity.ok(storehouseResponse.getBody());
    }
}
