package com.exemple.supermarket.service;

import com.exemple.supermarket.exception.RestTemplateResponseErrorHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SuperMarketService {

    public ResponseEntity<String> sendRequestToStorehouse(String name)  {
        String url = "http://localhost:8100/getProduct?name=";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());

        return restTemplate.getForEntity(url + name, String.class);
    }

    public JsonNode getResponseFromStorehouse(ResponseEntity<String> response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readTree(response.getBody());
    }
}
