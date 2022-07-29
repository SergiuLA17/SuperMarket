package com.exemple.supermarket.exception;

import com.exemple.supermarket.exception.exceptions.NotFoundProductException;
import com.exemple.supermarket.exception.exceptions.WrongQuantityException;
import com.exemple.supermarket.service.logger.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.net.ConnectException;

@ControllerAdvice
public class SupermarketControllerAdvice {
    @Autowired
    private LoggerService print;

    @ExceptionHandler(ConnectException.class)
    public void handleConnectException(){
        print.info("Server is off, contact administrator!");
    }

    @ExceptionHandler(NotFoundProductException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundProductException notFoundProductException){
        print.info("Request processing error. " + notFoundProductException.getMessage() + "\n");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundProductException.getMessage());
    }

    @ExceptionHandler(WrongQuantityException.class)
    public ResponseEntity<Object> exception(WrongQuantityException wrongQuantityException) {
        print.info("Request processing error. " + wrongQuantityException.getMessage() + "\n");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(wrongQuantityException.getMessage());
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public void handleException(){

    }




}


