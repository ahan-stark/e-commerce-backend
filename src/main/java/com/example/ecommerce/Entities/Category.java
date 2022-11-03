package com.example.ecommerce.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name = "categoryz")
public class Category {
    @Id
    Integer category_id;
    String catergory_name;

    public Category(Integer catergory_id, String catergory_name) {
        this.category_id = catergory_id;
        this.catergory_name = catergory_name;
    }

    public Integer getCatergory_id() {
        return category_id;
    }

    public void setCatergory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getCatergory_name() {
        return catergory_name;
    }

    public void setCatergory_name(String catergory_name) {
        this.catergory_name = catergory_name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "catergory_id=" + category_id +
                ", catergory_name='" + catergory_name + '\'' +
                '}';
    }
}
