package com.example.ecommerce.repository.supercart;

import com.example.ecommerce.dto.NotifyReturn;
import com.example.ecommerce.dto.SuperCartReturn;

import java.util.List;

public interface SuperCartQuery {
    public void addToSuperCart(Integer userId,Integer productId,Integer productBookingPrice);
    public List<SuperCartReturn> getSuperCart(Integer userId);
    public void deleteSuperCart(Integer userId, Integer productId);
    public  SuperCartReturn checkSuperCart(Integer userId, Integer productId);
    public List<NotifyReturn> getItemsToNotify();
    public void updateSuperCartStatus(Integer userId,Integer productId);
    public void bookFromSuperCart(Integer userId,Integer productId);
}
