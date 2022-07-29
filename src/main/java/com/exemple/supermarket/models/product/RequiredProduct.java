package com.exemple.supermarket.models.product;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class RequiredProduct {

    private  String name;
    private  int quantity;

}

