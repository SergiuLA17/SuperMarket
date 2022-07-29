package com.exemple.supermarket.exception;

import com.exemple.supermarket.print.Print;
import lombok.SneakyThrows;
import net.bytebuddy.asm.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private Print print;

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
                print.info("Wrong response!");
            }
        }
    }
}


