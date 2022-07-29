package com.exemple.supermarket.service.responseController;

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
    Response customResponse;
    @Autowired
    ResponseBody body;

    public HttpStatus getStatusCode(ResponseEntity<String> response){
        return response.getStatusCode();
    }

    public void setResponse(ResponseEntity<String> response){
        customResponse.create(response);
    }

    public Response getResponse(){
        return customResponse;
    }

    public  Optional<JsonNode> getBody(ResponseEntity<String> response) throws JsonProcessingException {
        return body.get(response);
    }

}
