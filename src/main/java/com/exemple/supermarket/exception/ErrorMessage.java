package com.exemple.supermarket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ErrorMessage {
    private static String message = "";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        ErrorMessage.message = message;
    }

    public String getErrorMessage(ResponseEntity<String> response) {

        if (response.getStatusCode()
                .series() == HttpStatus.Series.SERVER_ERROR) {
            if (response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
                setMessage("Failed to connect to the server. Contact administrator.");
            }
        } else if (response.getStatusCode()
                .series() == HttpStatus.Series.CLIENT_ERROR) {
            if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                setMessage("Product not found");
            }
        }
        return message;
    }
}
