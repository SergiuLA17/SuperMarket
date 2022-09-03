package com.exemple.supermarket.service.requestService;

import com.exemple.supermarket.exception.RestTemplateResponseErrorHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class CustomeRestTemplate implements iCustomeRestTemplate{
    @Override
    public RestTemplate create() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());
        return restTemplate;
    }
}
