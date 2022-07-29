package com.exemple.supermarket.print;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class Print implements iPrint {
    @Autowired
    private customLogger logger;
    @Override
    public void info(String text) {
        logger.request(text);
    }

    @Override
    public void info(ResponseEntity<String> response, String txt) {

    }
}
