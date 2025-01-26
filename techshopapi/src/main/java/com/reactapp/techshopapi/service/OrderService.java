package com.reactapp.techshopapi.service;

import com.reactapp.techshopapi.model.Account;
import com.reactapp.techshopapi.model.Cart;
import com.reactapp.techshopapi.model.Client;
import com.reactapp.techshopapi.model.Order;

import java.util.List;

public interface OrderService {
    public boolean addOrder(Cart cart,String address);
    public List<Order> getListOrder();
    public boolean deleteOrder(Order order);
    public boolean editOrder(Order order);
    public List<Order> getListOrderofClient(Account account);
}
