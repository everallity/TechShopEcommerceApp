package com.reactapp.techshopapi.respositories;

import com.reactapp.techshopapi.model.Order;
import com.reactapp.techshopapi.model.OrderItem;

import java.util.List;

public interface OrderItemDAO {
    public boolean addOrderItem(OrderItem orderItem);
    public List<OrderItem> getItembyOrder(Order order);
    public List<OrderItem> getListOrderItem();
    public List<OrderItem> getListOrderItembyProductID(int productid);
}
