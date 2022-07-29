package com.exemple.supermarket.models.request;

import com.exemple.supermarket.models.product.RequiredProduct;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@Jacksonized
public class MultiProductRequest {
    protected UUID requestUUID;
    private List<RequiredProduct> listOfRequiredProducts;

}
