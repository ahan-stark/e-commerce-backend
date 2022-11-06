package com.example.ecommerce.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name = "products")
public class Products {
    @Id
    Integer product_id;
    String product_name;
    Integer product_category_id;
    String product_image;

    public Products(Integer product_id, String product_name, Integer product_category_id, String product_image) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_category_id = product_category_id;
        this.product_image = product_image;
    }

    public Products() {
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Integer getProduct_category_id() {
        return product_category_id;
    }

    public void setProduct_category_id(Integer product_category_id) {
        this.product_category_id = product_category_id;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    @Override
    public String toString() {
        return "Products{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", product_category_id='" + product_category_id + '\'' +
                ", product_image='" + product_image + '\'' +
                '}';
    }
}
