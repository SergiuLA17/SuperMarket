package com.exemple.supermarket.models.response;

import com.exemple.supermarket.models.product.Product;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Data
@Builder
@Jacksonized
public class SingleProductResponse {
    private final UUID requestUUID;
    private final Product nameOfProduct;

}
