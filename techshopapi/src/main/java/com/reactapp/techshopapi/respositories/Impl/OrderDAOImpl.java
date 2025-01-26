package com.reactapp.techshopapi.respositories.Impl;

import com.reactapp.techshopapi.Util.DBUtil;
import com.reactapp.techshopapi.model.Account;
import com.reactapp.techshopapi.model.Order;
import com.reactapp.techshopapi.model.OrderItem;
import com.reactapp.techshopapi.respositories.OrderDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public boolean addOrder(Order order) {
        try(Connection connection= DBUtil.getInstance().getConnection()){
            String sql="insert into Orders(Shipping_Address,Shipping_Fee,Order_Status,Total_Amount,Create_At,Client_ID) values(?,?,?,?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,order.getShipping_address());
            preparedStatement.setFloat(2,order.getShipping_fee());
            preparedStatement.setString(3,order.getOrder_status());
            preparedStatement.setFloat(4,order.getTotal_amount());
            preparedStatement.setString(5,order.getCreate_at());
            preparedStatement.setInt(6,order.getClientid());
            int status=preparedStatement.executeUpdate();
            if(status==1){
                return true;
            }
            return false;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean editOrder(Order order) {
        try(Connection connection=DBUtil.getInstance().getConnection()){
            System.out.println(order);
            String sql="update Orders set Order_Status=? where Order_ID=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,order.getOrder_status());
            preparedStatement.setInt(2,order.getId());
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
    public boolean deleteOrder(Order order) {
        try(Connection connection=DBUtil.getInstance().getConnection()){
            String sql="delete from Orders where Order_ID=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,order.getId());
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
    public List<Order> getListOrder() {
        try(Connection connection =DBUtil.getInstance().getConnection()){
            List<Order> orders=new ArrayList<>();
            String sql="select * from Orders";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int oid=resultSet.getInt(1);
                String saddress=resultSet.getNString(2);
                float sfee=resultSet.getFloat(3);
                String status=resultSet.getNString(4);
                float total=resultSet.getFloat(5);
                String createat=resultSet.getString(6);
                int clientid=resultSet.getInt(7);
                Order order=new Order(oid,clientid,saddress,status,sfee,total,createat);
                orders.add(order);
            }
            return orders;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Order getlatestOrder() {
        try(Connection connection=DBUtil.getInstance().getConnection()){
            String sql="select * from Orders order by Order_ID desc limit 1";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.next();
            int orderid=resultSet.getInt(1);
            Order order=new Order();
            order.setId(orderid);
            return order;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Order> getListOrderofClient(int clientid) {
        try(Connection connection =DBUtil.getInstance().getConnection()){
            List<Order> orders=new ArrayList<>();
            String sql="select * from Orders where Client_ID =?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,clientid);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int oid=resultSet.getInt(1);
                String saddress=resultSet.getNString(2);
                float sfee=resultSet.getFloat(3);
                String status=resultSet.getNString(4);
                float total=resultSet.getFloat(5);
                String createat=resultSet.getString(6);
                Order order=new Order(oid,clientid,saddress,status,sfee,total,createat);
                orders.add(order);
            }
            return orders;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Order getOrderbyID(int orderid) {
        try(Connection connection=DBUtil.getInstance().getConnection()){
            String sql="Select * from Orders where Order_ID=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,orderid);
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.next();
            String saddress=resultSet.getNString(2);
            float sfee=resultSet.getFloat(3);
            String status=resultSet.getNString(4);
            float total=resultSet.getFloat(5);
            String createat=resultSet.getString(6);
            int clientid=resultSet.getInt(7);
            Order order=new Order(orderid,clientid,saddress,status,sfee,total,createat);
            return order;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
