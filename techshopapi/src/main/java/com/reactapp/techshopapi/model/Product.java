package com.reactapp.techshopapi.model;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {
    private int product_id,stock;
    private String name,brand,category,image,description;
    private float price;

    public Product() {
    }

    public Product(int stock, String name, String brand, String category, String image, String description, float price) {
        this.stock = stock;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.image = image;
        this.description = description;
        this.price = price;
    }

    public Product(int product_id, int stock, String name, String brand, String category, String image, String description, float price) {
        this.product_id = product_id;
        this.stock = stock;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.image = image;
        this.description = description;
        this.price = price;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", stock=" + stock +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
