package com.exemple.supermarket.service.responseController;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface iResponseBody {
    Optional<JsonNode> get(Optional<ResponseEntity<String>> response);
}
