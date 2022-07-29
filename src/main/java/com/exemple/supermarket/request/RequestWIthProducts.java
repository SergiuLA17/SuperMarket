package com.exemple.supermarket.request;

import com.exemple.supermarket.model.ProductRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class RequestWIthProducts extends Request{
    private ArrayList<ProductRequest> products;

    public ArrayList<ProductRequest> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<ProductRequest> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Request " +
                "idRequest=" + id +
                ", product=" + products +
                '}';
    }
}
