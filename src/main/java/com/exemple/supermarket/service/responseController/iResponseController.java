package com.exemple.supermarket.service.responseController;

import com.exemple.supermarket.print.Print;
import com.exemple.supermarket.service.SuperMarketService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface iResponseController {
    HttpStatus getStatusCode(ResponseEntity<String> response);
    Optional<JsonNode> getBody(Optional<ResponseEntity<String>> response);
    void  check(Optional<ResponseEntity<String>> response, SuperMarketService service, Print print);
}
