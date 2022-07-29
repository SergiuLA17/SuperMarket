package com.exemple.supermarket.models.product;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class RequiredProduct {

    private  String name;
    private  int quantity;

}

