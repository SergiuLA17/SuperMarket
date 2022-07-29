package com.exemple.supermarket.print;

import org.springframework.http.ResponseEntity;

public interface iPrint {
    void info(String text);
    void info(ResponseEntity<String> response, String txt);
}
