package com.exemple.supermarket.service.responseController;

import com.exemple.supermarket.print.Print;
import com.exemple.supermarket.service.SuperMarketService;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface iResponseStatus {
    void check(Optional<ResponseEntity<String>> response, SuperMarketService service, Print print);
}
