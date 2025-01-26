package com.reactapp.techshopapi.respositories;

import com.reactapp.techshopapi.model.Order;

import java.util.List;

public interface OrderDAO {
    public boolean addOrder(Order order);
    public boolean editOrder(Order order);
    public boolean deleteOrder(Order order);
    public List<Order> getListOrder();
    public Order getlatestOrder();
    public List<Order> getListOrderofClient(int clientid);
    public Order getOrderbyID(int orderid);
}
