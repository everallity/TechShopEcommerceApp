package com.reactapp.techshopapi.model;

import java.io.Serializable;

public class ProductStat extends Product implements Serializable {
    private int numbersold;
    private float revenue;

    public ProductStat(int numbersold, float revenue) {
        this.numbersold = numbersold;
        this.revenue = revenue;
    }

    public ProductStat() {
    }

    public ProductStat(int product_id, int stock, String name, String brand, String category, String image, String description, float price) {
        super(product_id, stock, name, brand, category, image, description, price);
    }

    public ProductStat(int product_id, int stock, String name, String brand, String category, String image, String description, float price, int numbersold, float revenue) {
        super(product_id, stock, name, brand, category, image, description, price);
        this.numbersold = numbersold;
        this.revenue = revenue;
    }

    public int getNumbersold() {
        return numbersold;
    }

    public void setNumbersold(int numbersold) {
        this.numbersold = numbersold;
    }

    public float getRevenue() {
        return revenue;
    }

    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }

    @Override
    public String toString() {
        return "ProductStat{" +
                "numbersold=" + numbersold +
                ", revenue=" + revenue +
                '}';
    }
}
