package com.exemple.supermarket.models.product;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class Product {
    private int idProduct;
    private String name;
    private int quantity;
    private LocalDateTime dateOfManufacture;
    private int daysToExpire;

}