package com.tech.stockmanagement.productservice.request;

import lombok.Data;

@Data
public class ProductUpdateRequest {
    private String productName;
    private Integer quantity;
    private Double price;
}
