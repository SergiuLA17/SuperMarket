package com.exemple.supermarket.models.request;

import com.exemple.supermarket.models.product.RefundProduct;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Data
@Builder
@Jacksonized
public class RefundRequest
{
    private UUID requestUUID;
    private RefundProduct refundProduct;

}
