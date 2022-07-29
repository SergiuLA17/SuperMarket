package com.exemple.supermarket.service.responseController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface iResponseController {
    HttpStatus getStatusCode(ResponseEntity<String> response);
    void setResponse(ResponseEntity<String> response);
    Response getResponse();
    Optional<JsonNode> getBody(ResponseEntity<String> response) throws JsonProcessingException;
}
