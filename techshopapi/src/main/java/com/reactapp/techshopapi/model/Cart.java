package com.reactapp.techshopapi.model;

import java.io.Serializable;
import java.util.List;

public class Cart implements Serializable {
    private int id,clientid;
    private float final_amount;
    private List<CartItem> cartItemList;

    public Cart(int id, int clientid, float final_amount, List<CartItem> cartItemList) {
        this.id = id;
        this.clientid = clientid;
        this.final_amount = final_amount;
        this.cartItemList = cartItemList;
    }

    public Cart() {
    }

    public Cart(int id, int clientid, float final_amount) {
        this.id = id;
        this.clientid = clientid;
        this.final_amount = final_amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public float getFinal_amount() {
        return final_amount;
    }

    public void setFinal_amount(float final_amount) {
        this.final_amount = final_amount;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", clientid=" + clientid +
                ", final_amount=" + final_amount +
                ", cartItemList=" + cartItemList +
                '}';
    }
}
