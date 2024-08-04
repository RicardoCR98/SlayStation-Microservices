package com.microservice_userpurchase.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPurchaseDTO {
    private Integer purchaseId;
    private Integer quantity;
    private Double totalPrice;
    private Integer userId;
    private Integer productId;
}
