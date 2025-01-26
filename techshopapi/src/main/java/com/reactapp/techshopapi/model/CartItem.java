package com.reactapp.techshopapi.model;

import com.reactapp.techshopapi.model.unused.ShopItem;

import java.io.Serializable;
import java.sql.PreparedStatement;

public class CartItem implements Serializable {
    private int id,quantity;
    private int cart_id;
    private Product product;
    private float totalamount;

    public CartItem() {
    }

    public CartItem(int id, int quantity, int cart_id, float totalamount) {
        this.id = id;
        this.quantity = quantity;
        this.cart_id = cart_id;
        this.totalamount = totalamount;
    }

    public CartItem(int id, int quantity, int cart_id, Product product, float totalamount) {
        this.id = id;
        this.quantity = quantity;
        this.cart_id = cart_id;
        this.product = product;
        this.totalamount = totalamount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public float getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(float totalamount) {
        this.totalamount = totalamount;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", cart_id=" + cart_id +
                ", product=" + product +
                ", totalamount=" + totalamount +
                '}';
    }
}
