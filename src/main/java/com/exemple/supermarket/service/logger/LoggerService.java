package com.exemple.supermarket.service.logger;

import com.exemple.supermarket.controllers.MainController;
import com.exemple.supermarket.models.request.CheckQuantityOfProductRequest;
import com.exemple.supermarket.models.request.RefundRequest;
import com.exemple.supermarket.models.request.SingleProductRequest;
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

    public void requestInfo(Object obj){
        logger.info("Request has been send. Request info:  " + obj);
    }


}
