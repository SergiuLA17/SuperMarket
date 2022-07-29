package com.exemple.supermarket.service.responseController;

import com.exemple.supermarket.print.Print;
import com.exemple.supermarket.service.SuperMarketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ResponseStatus implements iResponseStatus {

    public void  check(Optional<ResponseEntity<String>> response, SuperMarketService service, Print print) {
       if(response.isPresent()) {
           try {
               if (response.get().getStatusCode() == HttpStatus.NOT_FOUND) {
                   print.info("Storehouse response: " + response.get().getBody());
                   ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
               } else print.info("The request having been granted");
               try {
                   print.info("Response = " + service.response(response).get() + " has been sent to buyer");
               } catch (Exception e) {
                   print.info(String.valueOf(e));
               }
           } catch (NullPointerException e) {
               print.info(String.valueOf(e));
           }
       }
       else
           print.info("Response is empty");
    }
}
