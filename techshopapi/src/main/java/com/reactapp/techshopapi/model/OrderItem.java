package com.reactapp.techshopapi.model;

import java.io.Serializable;

public class OrderItem implements Serializable {
    private int id,orderid,quantity;
    private float totalamount;
    private Product product;

    public OrderItem() {
    }

    public OrderItem(int id, int orderid, int quantity, float totalamount, Product product) {
        this.id = id;
        this.orderid = orderid;
        this.quantity = quantity;
        this.totalamount = totalamount;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(float totalamount) {
        this.totalamount = totalamount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", orderid=" + orderid +
                ", quantity=" + quantity +
                ", totalamount=" + totalamount +
                ", product=" + product +
                '}';
    }
}
