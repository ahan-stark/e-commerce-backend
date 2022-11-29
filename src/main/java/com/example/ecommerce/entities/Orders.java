package com.example.ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orders {
    @Id
    Long orderId;
    Long userId;
    Long productId;
    Long orderTimeStamp;

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", productId=" + productId +
                ", orderTimeStamp=" + orderTimeStamp +
                '}';
    }
}
