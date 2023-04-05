package com.tech.stockmanagement.productservice.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class ProductResponse {
    private Long productId;
    private String productName;
    private Integer quantity;
    private Double price;
    private Long productCreatedDate;
    private Long productUpdatedDate;
}
