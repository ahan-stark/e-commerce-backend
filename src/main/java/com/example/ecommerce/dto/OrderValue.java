package com.example.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderValue {
    private Integer productId;
    private String productImage;
    private String productName;
    private Integer productPrice;
    private Long orderTime;
}
