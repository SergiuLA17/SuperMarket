package com.exemple.supermarket.exception;


import com.exemple.supermarket.exception.exceptions.NotFoundProductException;
import com.exemple.supermarket.exception.exceptions.WrongQuantityException;
import com.exemple.supermarket.service.logger.LoggerService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

@Component
public class RestTemplateResponseErrorHandler extends IOException implements ResponseErrorHandler {
    @Autowired
    private LoggerService print;

    @Override
    public boolean hasError(ClientHttpResponse httpResponse) throws IOException {
        return (httpResponse.getStatusCode().series() == CLIENT_ERROR || httpResponse.getStatusCode().series() == SERVER_ERROR);
    }

    @SneakyThrows
    @Override
    public void handleError(ClientHttpResponse httpResponse) {
        if (httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR) {
            if (httpResponse.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
                print.info(httpResponse.getStatusCode() + "Something wrong. Contact the server administrator.");
            }
        } else if (httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR) {
            if (httpResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new NotFoundProductException("Desired product not found");
            }
            if (httpResponse.getStatusCode() == HttpStatus.BAD_REQUEST) {
                throw new WrongQuantityException("Wrong quantity value");
            }

        }
    }
}
