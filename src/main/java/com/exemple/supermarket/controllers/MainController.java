package com.exemple.supermarket.controllers;

import com.exemple.supermarket.exception.ErrorMessage;
import com.exemple.supermarket.service.SuperMarketService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

import java.net.ConnectException;
import java.util.ArrayList;


@Controller
public class MainController {
    @Autowired
    SuperMarketService service;
    @Autowired
    ErrorMessage errorMessage;
    Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "/getProduct")
    public String sendRequestToStorehouse(@ModelAttribute("name") String name, @ModelAttribute("name") String quantity, Model model) {

        ResponseEntity<String> response = null;
        try {
            response = service.sendRequestToStorehouse(name, quantity);
            model.addAttribute("message", service.getResponseFromStorehouse(response));
            logger.info(String.valueOf(service.getResponseFromStorehouse(response)));
        } catch (JsonProcessingException e) {
            model.addAttribute("message", errorMessage.getErrorMessage(response));

        } catch (RestClientException e) {
            if (e.getCause() instanceof ConnectException) {
                model.addAttribute("message", "Failed to connect to the server. Contact administrator.");
                logger.error("Failed to connect to the server. Contact administrator.");
            }
        }
        return "getProduct";
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "/1000purchases")
    public String send1000PurchasesRequest() {

        for (int i = 0; i < 1000; i++) {
            service.putRandomParamInRequest(i);
        }

        return "done";
    }
}