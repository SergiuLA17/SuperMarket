package com.exemple.supermarket.service.responseController;

import com.exemple.supermarket.model.Product;
import com.exemple.supermarket.print.Print;
import com.exemple.supermarket.service.SuperMarketService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ResponseController implements iResponseController{
    @Autowired
    ResponseBody body;
    @Autowired
    ResponseStatus responseStatus;

    public HttpStatus getStatusCode(ResponseEntity<String> response){
        return response.getStatusCode();
    }

    public  Optional<JsonNode> getBody(Optional<ResponseEntity<String>> response) {
        return body.get(response);
    }

    public void  check(Optional<ResponseEntity<String>> response, SuperMarketService service, Print print){
        responseStatus.check(response,service,print);
    }
}
