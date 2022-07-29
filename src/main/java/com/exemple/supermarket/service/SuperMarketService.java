package com.exemple.supermarket.service;

import com.exemple.supermarket.controllers.MainController;
import com.exemple.supermarket.model.Product;
import com.exemple.supermarket.model.ProductController;
import com.exemple.supermarket.service.requestController.RequestController;
import com.exemple.supermarket.service.responseController.ResponseController;
import com.exemple.supermarket.service.url.CustomURL;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


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

    public ResponseEntity<String> sendRequestToStorehouse(String name, String quantity) {
        return requestController.send(URL.StorehouseURL(name,quantity));
    }

    public Optional<JsonNode> getResponseFromStorehouse(ResponseEntity<String> response) throws JsonProcessingException {
        return responseController.getBody(response);
    }

    public Optional<Product> getProductFromRequest(JsonNode jsonNode) {
        return productController.returnProduct(jsonNode);
    }

}
