package com.example.ecommerce.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name = "category")
public class Category {
    @Id
    Integer category_id;
    String category_name;

    public Category(Integer category_id, String category_name) {
        this.category_id = category_id;
        this.category_name = category_name;
    }

    public Category() {
    }

    public Integer getcategory_id() {
        return category_id;
    }

    public void setcategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getcategory_name() {
        return category_name;
    }

    public void setcategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category_id=" + category_id +
                ", category_name='" + category_name + '\'' +
                '}';
    }
}
