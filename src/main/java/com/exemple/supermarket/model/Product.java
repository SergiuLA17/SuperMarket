package com.exemple.supermarket.model;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class Product {
    private String name;
    private int quantity;
    private LocalDateTime dateOfManufacture;
    private int daysToExpire;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(LocalDateTime dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public int getDaysToExpire() {
        return daysToExpire;
    }

    public void setDaysToExpire(int daysToExpire) {
        this.daysToExpire = daysToExpire;
    }

    @Override
    public String toString() {
        return "Product{" +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", dateOfManufacture=" + dateOfManufacture +
                ", daysToExpire=" + daysToExpire +
                '}';
    }
}
