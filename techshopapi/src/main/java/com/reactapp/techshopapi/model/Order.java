package com.reactapp.techshopapi.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Order implements Serializable {
    private int id,clientid;
    private String shipping_address,order_status;
    private float shipping_fee,total_amount;
    private String create_at;
    private List<OrderItem> orderItems;
    public Order() {
    }

    public Order(int id, int clientid, String shipping_address, String order_status, float shipping_fee, float total_amount, String create_at, List<OrderItem> orderItems) {
        this.id = id;
        this.clientid = clientid;
        this.shipping_address = shipping_address;
        this.order_status = order_status;
        this.shipping_fee = shipping_fee;
        this.total_amount = total_amount;
        this.create_at = create_at;
        this.orderItems = orderItems;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Order(int id, int clientid, String shipping_address, String order_status, float shipping_fee, float total_amount, String create_at) {
        this.id = id;
        this.clientid = clientid;
        this.shipping_address = shipping_address;
        this.order_status = order_status;
        this.shipping_fee = shipping_fee;
        this.total_amount = total_amount;
        this.create_at = create_at;
    }

    public Order(int id, String shipping_address, String order_status, float shipping_fee, float total_amount, String create_at) {
        this.id = id;
        this.shipping_address = shipping_address;
        this.order_status = order_status;
        this.shipping_fee = shipping_fee;
        this.total_amount = total_amount;
        this.create_at = create_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShipping_address() {
        return shipping_address;
    }

    public void setShipping_address(String shipping_address) {
        this.shipping_address = shipping_address;
    }

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public float getShipping_fee() {
        return shipping_fee;
    }

    public void setShipping_fee(float shipping_fee) {
        this.shipping_fee = shipping_fee;
    }

    public float getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(float total_amount) {
        this.total_amount = total_amount;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", clientid=" + clientid +
                ", shipping_address='" + shipping_address + '\'' +
                ", order_status='" + order_status + '\'' +
                ", shipping_fee=" + shipping_fee +
                ", total_amount=" + total_amount +
                ", create_at='" + create_at + '\'' +
                ", orderItems=" + orderItems +
                '}';
    }
}
