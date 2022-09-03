package com.exemple.supermarket.models.response;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder

public class RefundResponse {
    private final UUID requestUUID;
    private final String message;

}

