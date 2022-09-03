package com.exemple.supermarket.models.request;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Builder
@Data
@Jacksonized
public class CheckQuantityOfProductRequest {
    String nameOfProduct;
    UUID requestUUID;
}
