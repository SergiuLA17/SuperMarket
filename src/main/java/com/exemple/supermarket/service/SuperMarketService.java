package com.exemple.supermarket.service;

import com.exemple.supermarket.model.Product;
import com.exemple.supermarket.model.ProductController;
import com.exemple.supermarket.request.Request;
import com.exemple.supermarket.request.RequestRefund;
import com.exemple.supermarket.service.requestController.RequestController;
import com.exemple.supermarket.service.responseController.ResponseController;
import com.exemple.supermarket.service.url.CustomURL;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;


@Service
public class SuperMarketService implements iSuperMarketService {
    @Autowired
    private CustomURL URL;
    @Autowired
    private ResponseController responseController;
    @Autowired
    private RequestController requestController;
    @Autowired
    private ProductController productController;

    public ResponseEntity<String> buy(UUID id, String name, String quantity) {
        return requestController.send(URL.singleProduct(id,name,quantity));
    }

    public ResponseEntity<String> checkQuantity(UUID id, String name) {
        return requestController.send(URL.checkQuantity(id,name));
    }

    public ResponseEntity<String> refund(RequestRefund refund ) {
        return requestController.send(URL.refund(),refund);
    }

    public ResponseEntity<String> buyMultiProducts(Request request ) {
        return requestController.send(URL.multiProducts(),request);
    }

    public Optional<JsonNode> response(Optional<ResponseEntity<String>> response) {
        return responseController.getBody(response);
    }

    public Optional<Product> getProductFromRequest(JsonNode jsonNode) {
        return productController.returnProduct(jsonNode);
    }

}
