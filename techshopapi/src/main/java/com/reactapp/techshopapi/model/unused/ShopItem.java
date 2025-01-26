package com.reactapp.techshopapi.model.unused;

public class ShopItem {
    private int id,stock;
    private String image,name,category;
    private float price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ShopItem(int id, int stock, String image, String name, String category, float price) {
        this.id = id;
        this.stock = stock;
        this.image = image;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public ShopItem() {
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", stock=" + stock +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
