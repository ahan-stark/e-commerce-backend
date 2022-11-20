package com.example.ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name = "cart")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cart {
    @Id
    Integer cartId;
    Integer userId;
    Integer productId;

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", userId=" + userId +
                ", productId=" + productId +
                '}';
    }
}
