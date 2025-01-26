package com.reactapp.techshopapi.model.unused;

import java.io.Serializable;
import java.util.List;

public class Accessories implements Serializable {
    private int id;
    private String name,color,brand,details;
    private List<String> imgs;

    public Accessories() {
    }

    public Accessories(int id, String name, String color, String brand, String details, List<String> imgs) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.brand = brand;
        this.details = details;
        this.imgs = imgs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<String> getImgs() {
        return imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }

    @Override
    public String toString() {
        return "Accessories{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                ", details='" + details + '\'' +
                ", imgs=" + imgs +
                '}';
    }
}
