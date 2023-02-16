package com.example.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuperCart {
    private Integer userId;
    private Integer productId;
    private Integer productBookingPrice;
}
