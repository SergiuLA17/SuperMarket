package com.exemple.supermarket.service.logger;

import com.exemple.supermarket.controllers.MainController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggerService implements iLoggerService {
    private final Logger logger = LoggerFactory.getLogger(MainController.class);

    public void request(String text) {
        logger.info(text);
    }

    public void info(String text) {
        logger.info(text);
    }

}
