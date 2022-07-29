package com.exemple.supermarket.models.response;

import com.exemple.supermarket.models.product.Product;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@Jacksonized
public class MultiProductsResponse {
    private final UUID uuid;
    private final List<Product> products;

}
