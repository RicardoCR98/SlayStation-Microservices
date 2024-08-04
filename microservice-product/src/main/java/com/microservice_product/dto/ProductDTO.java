package com.microservice_product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Integer productId;
    private String productName;
    private String productDescription;
    private Double productPrice;
    private Integer productStock;
    private String productImage;
    private Integer categoryId;
    private Integer stateId;
}