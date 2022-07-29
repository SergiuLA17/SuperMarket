package com.exemple.supermarket.service.responseController;

import com.exemple.supermarket.model.Product;
import com.exemple.supermarket.print.Print;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
public class ResponseBody implements iResponseBody {
    @Autowired
    private Mapper mapper;
    @Autowired
    private Print print;

    @Override
    public Optional<JsonNode> get(Optional<ResponseEntity<String>> response) {

        if (response.isPresent()) {
            try {
                return Optional.of(mapper.create().readTree(response.get().getBody()));
            } catch (JsonProcessingException e) {
                print.info("Error! " + e);
            }
        }
        return Optional.empty();
    }

}
