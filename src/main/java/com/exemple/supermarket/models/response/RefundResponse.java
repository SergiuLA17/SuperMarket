package com.exemple.supermarket.models.response;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Data
@Builder
@Jacksonized
public class RefundResponse {
    private final UUID requestUUID;
    private final String message;

}

