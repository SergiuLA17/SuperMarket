package com.exemple.supermarket.service;

import com.exemple.supermarket.models.request.CheckQuantityOfProductRequest;
import com.exemple.supermarket.models.request.MultiProductRequest;
import com.exemple.supermarket.models.request.RefundRequest;
import com.exemple.supermarket.models.request.SingleProductRequest;
import com.exemple.supermarket.models.response.CheckQuantityResponse;
import com.exemple.supermarket.models.response.MultiProductsResponse;
import com.exemple.supermarket.models.response.RefundResponse;
import com.exemple.supermarket.models.response.SingleProductResponse;
import org.springframework.http.ResponseEntity;

public interface iSupermarketService {
    ResponseEntity<SingleProductResponse> buySingleProduct(SingleProductRequest request);
    ResponseEntity<CheckQuantityResponse> checkQuantity(CheckQuantityOfProductRequest request);
    ResponseEntity<RefundResponse> returnProduct(RefundRequest request);
    ResponseEntity<MultiProductsResponse> buyMultiProducts(MultiProductRequest request);
}
