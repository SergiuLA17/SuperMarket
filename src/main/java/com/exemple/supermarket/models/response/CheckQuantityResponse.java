package com.exemple.supermarket.models.response;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Builder
@Data
@Jacksonized
public class CheckQuantityResponse {
    private final UUID requestUUID;
    private final String nameOfProduct;
    private final int quantityOfProduct;
}
