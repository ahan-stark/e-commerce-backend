package com.example.ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Products {
    @Id
    Integer productId;
    String productName;
    Integer productCategoryId;
    @Column(length = 10000)
    String productImage;
    Integer productPrice;


    @Override
    public String toString() {
        return "Products{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productCategoryId='" + productCategoryId + '\'' +
                ", productImage='" + productImage + '\'' +
                '}';
    }
}
