package com.exemple.supermarket.request;

import com.exemple.supermarket.model.Product;

public class RequestRefund extends Request {
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Refund{" +
                "idRequest=" + id +
                ", product=" + product +
                '}';
    }
}
