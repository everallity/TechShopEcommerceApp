package com.reactapp.techshopapi.respositories.Impl;

import com.fasterxml.jackson.databind.node.DecimalNode;
import com.reactapp.techshopapi.Util.DBUtil;
import com.reactapp.techshopapi.model.Cart;
import com.reactapp.techshopapi.model.Client;
import com.reactapp.techshopapi.respositories.CartDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CartDAOImpl implements CartDAO {
    @Override
    public boolean addCart(Cart cart) {
        try(Connection connection= DBUtil.getInstance().getConnection()){
            String sql="insert into Cart(Client_ID) values (?)";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,cart.getClientid());
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
    public Cart getCartofClient(Client client) {
        try(Connection connection=DBUtil.getInstance().getConnection()) {
            String sql="select * from Cart where Client_ID=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,client.getClient_id());
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.next();
            int cartid=resultSet.getInt(1);
            float finalamount=resultSet.getFloat(2);
            Cart cart=new Cart(cartid,client.getClient_id(),finalamount);
            return cart;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateCart(Cart cart) {
        try(Connection connection= DBUtil.getInstance().getConnection()){
            String sql="update Cart set Final_Amount=? where Cart_ID=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setFloat(1,cart.getFinal_amount());
            preparedStatement.setInt(2,cart.getId());
            int status=preparedStatement.executeUpdate();
            if(status==1)
                return true;
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Cart getCartbyID(int cartid) {
        try(Connection connection=DBUtil.getInstance().getConnection()){
            String sql="select * from Cart where Cart_ID=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,cartid);
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.next();
            float final_amount=resultSet.getFloat(2);
            int clientid=resultSet.getInt(3);
            Cart cart=new Cart(cartid,clientid,final_amount);
            return cart;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
