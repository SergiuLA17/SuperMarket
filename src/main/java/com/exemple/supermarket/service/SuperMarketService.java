package com.exemple.supermarket.service;

import com.exemple.supermarket.model.Product;
import com.exemple.supermarket.controllers.MainController;
import com.exemple.supermarket.exception.RestTemplateResponseErrorHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.ConnectException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;


@Service
public class SuperMarketService {
    private final Logger logger = LoggerFactory.getLogger(MainController.class);
    ArrayList<String> nameOfProducts = getTheNameOfTheDesiredProducts();

    public ResponseEntity<String> sendRequestToStorehouse(String name, String quantity) {
        String url = "http://localhost:8100/getProduct?name=" + name + "&quantity=" + quantity;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());

        try {
            return restTemplate.getForEntity(url, String.class);
        } catch (RestClientException e) {
            logger.error("Error" + e);
            return restTemplate.getForEntity(url, String.class);

        }
    }

    public Optional<JsonNode> getResponseFromStorehouse(ResponseEntity<String> response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return Optional.of(mapper.readTree(response.getBody()));
    }

    public ArrayList<String> getTheNameOfTheDesiredProducts() {
        ArrayList<String> nameOfDesireProducts = new ArrayList<>();
        nameOfDesireProducts.add("Potato");
        nameOfDesireProducts.add("Salt");
        nameOfDesireProducts.add("Sugar");
        nameOfDesireProducts.add("Apple");
        nameOfDesireProducts.add("Banana");
        nameOfDesireProducts.add("Kiwi");
        nameOfDesireProducts.add("Carrot");
        nameOfDesireProducts.add("Mango");
        nameOfDesireProducts.add("Orange");
        nameOfDesireProducts.add("Pear");
        nameOfDesireProducts.add("Peach");

        return nameOfDesireProducts;
    }

    public void putRandomParamInRequest(int index) {
        String name;
        int quantity;
        ResponseEntity<String> response;

        try {
            name = nameOfProducts.get((int) (Math.random() * nameOfProducts.size()));
            quantity = 10 + (int) (Math.random() * 30);
            logger.info("Request " + index + " to purchase " + quantity + " of <" + name + "> has been sent. ");
            response = sendRequestToStorehouse(name, String.valueOf(quantity));
            logger.info("Product has been purchased" + getResponseFromStorehouse(response));
            Thread.sleep(60);
        } catch (JsonProcessingException | InterruptedException ignored) {

        } catch (RestClientException e) {
            if (e.getCause() instanceof ConnectException) {
                logger.error("Error:  " + e);
            }
        }
    }


    public Optional<Product> getProductFromRequest(JsonNode jsonNode) {
        Product product = new Product();
        try {
            product.setName(String.valueOf(jsonNode.get("name")));
            product.setQuantity(Integer.parseInt(String.valueOf(jsonNode.get("quantity"))));
            product.setDaysToExpire(Integer.parseInt(String.valueOf(jsonNode.get("quantity"))));
            product.setDateOfManufacture(LocalDateTime.parse(jsonNode.get("dateOfManufacture").asText()));
        } catch (Exception ignored) {
            System.out.println(jsonNode.get("dateOfManufacture") + " " + product.getDateOfManufacture());

        }
        return Optional.of(product);
    }

}
