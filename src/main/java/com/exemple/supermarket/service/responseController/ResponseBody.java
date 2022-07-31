package com.exemple.supermarket.service.responseController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ResponseBody implements iResponseBody{
    @Autowired
    private Mapper mapper;

    @Override
    public Optional<JsonNode> get(ResponseEntity<String> response) throws JsonProcessingException {
        return Optional.of(mapper.create().readTree(response.getBody()));
    }
}
