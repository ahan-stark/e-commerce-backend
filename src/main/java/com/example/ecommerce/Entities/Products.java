package com.example.ecommerce.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name = "products")
public class Products {
    @Id
    Integer productId;
    String productName;
    Integer productCategoryId;
    String productImage;

    public Products(Integer productId, String productName, Integer productCategoryId, String productImage) {
        this.productId = productId;
        this.productName = productName;
        this.productCategoryId = productCategoryId;
        this.productImage = productImage;
    }

    public Products() {
    }

    public Integer getproductId() {
        return productId;
    }

    public void setproductId(Integer productId) {
        this.productId = productId;
    }

    public String getproductName() {
        return productName;
    }

    public void setproductName(String productName) {
        this.productName = productName;
    }

    public Integer getproductCategoryId() {
        return productCategoryId;
    }

    public void setproductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getproductImage() {
        return productImage;
    }

    public void setproductImage(String productImage) {
        this.productImage = productImage;
    }

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
