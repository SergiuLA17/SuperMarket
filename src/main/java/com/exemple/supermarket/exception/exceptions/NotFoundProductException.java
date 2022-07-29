package com.exemple.supermarket.exception.exceptions;

public class NotFoundProductException extends RuntimeException {

    public NotFoundProductException(String message) {
        super(message);
    }

}
