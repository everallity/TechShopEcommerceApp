package com.reactapp.techshopapi.respositories.Impl;

import com.reactapp.techshopapi.Util.DBUtil;
import com.reactapp.techshopapi.model.Order;
import com.reactapp.techshopapi.model.OrderItem;
import com.reactapp.techshopapi.model.Product;
import com.reactapp.techshopapi.respositories.OrderItemDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDAOImpl implements OrderItemDAO {
    @Override
    public boolean addOrderItem(OrderItem orderItem) {
        try(Connection connection= DBUtil.getInstance().getConnection()){
            String sql="insert into OrderItem(OrderItem_ID,Quantity,Total_Amount,Product_ID,Order_ID) values(?,?,?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,orderItem.getId());
            preparedStatement.setInt(2,orderItem.getQuantity());
            preparedStatement.setFloat(3,orderItem.getTotalamount());
            preparedStatement.setInt(4,orderItem.getProduct().getProduct_id());
            preparedStatement.setInt(5,orderItem.getOrderid());
            int status=preparedStatement.executeUpdate();
            if(status==1){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<OrderItem> getItembyOrder(Order order) {
        try(Connection connection=DBUtil.getInstance().getConnection()){
            List<OrderItem> orderItems=new ArrayList<>();
            String sql="select * from OrderItem where Order_ID=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,order.getId());
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt(1);
                int quantity=resultSet.getInt(2);
                float totalamount=resultSet.getFloat(3);
                int pid=resultSet.getInt(4);
                Product product=new Product();
                product.setProduct_id(pid);
                OrderItem orderItem=new OrderItem(id,order.getId(),quantity,totalamount,product);
                orderItems.add(orderItem);
            }
            return orderItems;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<OrderItem> getListOrderItem() {
        try(Connection connection=DBUtil.getInstance().getConnection()){
            List<OrderItem> orderItems=new ArrayList<>();
            String sql="select * from OrderItem";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt(1);
                int quantity=resultSet.getInt(2);
                float totalamount=resultSet.getFloat(3);
                int pid=resultSet.getInt(4);
                int oid=resultSet.getInt(5);
                Product product=new Product();
                product.setProduct_id(pid);
                OrderItem orderItem=new OrderItem(id,oid,quantity,totalamount,product);
                orderItems.add(orderItem);
            }
            return orderItems;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<OrderItem> getListOrderItembyProductID(int productid) {
        try(Connection connection=DBUtil.getInstance().getConnection()){
            List<OrderItem> orderItems=new ArrayList<>();
            String sql="select * from OrderItem where Product_ID=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,productid);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt(1);
                int quantity=resultSet.getInt(2);
                float totalamount=resultSet.getFloat(3);
                int oid=resultSet.getInt(5);
                Product product=new Product();
                product.setProduct_id(productid);
                OrderItem orderItem=new OrderItem(id,oid,quantity,totalamount,product);
                orderItems.add(orderItem);
            }
            return orderItems;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
