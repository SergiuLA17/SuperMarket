package com.exemple.supermarket.service.url;

import java.util.UUID;

public interface iCustomURL {
    String singleProduct(UUID id, String name, String quantity);
    String multiProducts();
    String checkQuantity(UUID id,String name);
    String refund();
}
