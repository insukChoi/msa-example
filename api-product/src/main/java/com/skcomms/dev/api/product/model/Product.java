package com.skcomms.dev.api.product.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private String id;
    private String name;
    private int price;

}
