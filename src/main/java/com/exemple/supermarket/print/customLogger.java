package com.exemple.supermarket.print;

import com.exemple.supermarket.controllers.MainController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class customLogger implements iLogger {
    private final Logger logger;

    public customLogger() {
        this.logger = LoggerFactory.getLogger(MainController.class);;
    }

    @Override
    public void request(String text) {
        logger.info(text);
    }

    @Override
    public void response(ResponseEntity<String> response, String txt) {

    }
}
