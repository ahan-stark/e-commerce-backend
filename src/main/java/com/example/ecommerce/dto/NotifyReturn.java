package com.example.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotifyReturn {
    private Integer productId;
    private Integer productPrice;
    private String productName;
    private Integer productBookingPrice;
    private Long userId;
    private String bookingStatus;
}
