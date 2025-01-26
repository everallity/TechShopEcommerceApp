package com.reactapp.techshopapi.service.Impl;

import com.reactapp.techshopapi.model.*;
import com.reactapp.techshopapi.respositories.*;
import com.reactapp.techshopapi.respositories.Impl.*;
import com.reactapp.techshopapi.service.OrderService;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private static ClientDAO clientDAO=new ClientDAOImpl();
    private static OrderDAO orderDAO=new OrderDAOImpl();
    private static CartItemDAO cartItemDAO=new CartItemDAOImpl();
    private static OrderItemDAO orderItemDAO=new OrderItemDAOImpl();
    private static CartDAO cartDAO=new CartDAOImpl();
    private static ProductDAO productDAO=new ProductDAOImpl();
    @Override
    public boolean addOrder(Cart cart,String address) {
        Order order=new Order();
        Client client=clientDAO.getClientbyClientID(cart.getClientid());
        order.setOrder_status("Pending");
        order.setShipping_address(address);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        order.setCreate_at(dtf.format(now));
        order.setShipping_fee(50000);
        order.setClientid(client.getClient_id());
        order.setTotal_amount(cart.getFinal_amount()+order.getShipping_fee());
        boolean status= orderDAO.addOrder(order);
        if(!status){
            return false;
        }
        cart.setFinal_amount(0);
        cartDAO.updateCart(cart);
        Order newestorder=orderDAO.getlatestOrder();
        List<CartItem> cartItems=cartItemDAO.getListCartItemofCart(cart);
        for(CartItem c:cartItems){
            OrderItem o=new OrderItem();
            o.setOrderid(newestorder.getId());
            o.setProduct(c.getProduct());
            o.setQuantity(c.getQuantity());
            o.setTotalamount(c.getTotalamount());
            orderItemDAO.addOrderItem(o);
            cartItemDAO.deleteCartItem(c);
        }
        return true;
    }

    @Override
    public List<Order> getListOrder() {
        return orderDAO.getListOrder();
    }

    @Override
    public boolean deleteOrder(Order order) {
        return orderDAO.deleteOrder(order);
    }

    @Override
    public boolean editOrder(Order order) {
        return orderDAO.editOrder(order);
    }

    @Override
    public List<Order> getListOrderofClient(Account account) {
        Client client=clientDAO.getClientbyAccountID(account.getId());
        List<Order> orders=orderDAO.getListOrderofClient(client.getClient_id());
        for(Order o:orders){
            List<OrderItem> orderItems=orderItemDAO.getItembyOrder(o);
            for(OrderItem oi:orderItems){
                Product product=productDAO.getProductbyId(oi.getProduct().getProduct_id());
                oi.setProduct(product);
            }
            o.setOrderItems(orderItems);
        }
        return orders;
    }
}
