package com.exemple.supermarket.print;

import org.springframework.http.ResponseEntity;

public interface iLogger {
    void request(String text);
    void response(ResponseEntity<String> response, String txt);
}
