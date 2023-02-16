package com.example.ecommerce.repository.supercart;

import com.example.ecommerce.dto.SuperCartReturn;

import java.util.List;

public interface SuperCartQuery {
    public void addToSuperCart(Integer userId,Integer productId,Integer productBookingPrice);
    public List<SuperCartReturn> getSuperCart(Integer userId);
}
