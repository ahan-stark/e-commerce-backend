package com.example.ecommerce.repository.supercart;

public interface SuperCartQuery {
    public void addToSuperCart(Integer userId,Integer productId,Integer productBookingPrice);
}
