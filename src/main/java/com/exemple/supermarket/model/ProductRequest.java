package com.exemple.supermarket.model;

import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.UUID;
@EntityScan
@NoArgsConstructor
public class ProductRequest {
    private String name;
    private int quantity;

    public ProductRequest(UUID id, String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }


    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
