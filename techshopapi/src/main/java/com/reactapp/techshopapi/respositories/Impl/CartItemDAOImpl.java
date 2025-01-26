package com.reactapp.techshopapi.respositories.Impl;

import com.reactapp.techshopapi.Util.DBUtil;
import com.reactapp.techshopapi.model.Cart;
import com.reactapp.techshopapi.model.CartItem;
import com.reactapp.techshopapi.model.Product;
import com.reactapp.techshopapi.respositories.CartItemDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartItemDAOImpl implements CartItemDAO {
    @Override
    public boolean addCartItem(CartItem cartItem) {
        try(Connection connection= DBUtil.getInstance().getConnection()){
            String sql="insert into CartItem(CartItem_ID,Quantity,Total_Amount,Product_ID,Cart_ID) values(?,?,?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,cartItem.getId());
            preparedStatement.setInt(2,cartItem.getQuantity());
            preparedStatement.setFloat(3,cartItem.getTotalamount());
            preparedStatement.setInt(4,cartItem.getProduct().getProduct_id());
            preparedStatement.setInt(5,cartItem.getCart_id());
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
    public boolean deleteCartItem(CartItem cartItem) {
        try(Connection connection=DBUtil.getInstance().getConnection()){
            String sql="delete from CartItem where CartItem_ID=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,cartItem.getId());
            int status=preparedStatement.executeUpdate();
            if(status ==1){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateCartItem(CartItem cartItem) {
        try(Connection connection= DBUtil.getInstance().getConnection()){
            String sql="update CartItem set Quantity=?, Total_Amount=? where CartItem_ID=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,cartItem.getQuantity());
            preparedStatement.setFloat(2,cartItem.getTotalamount());
            preparedStatement.setInt(3,cartItem.getId());
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
    public List<CartItem> getListCartItemofCart(Cart cart) {
        try(Connection connection=DBUtil.getInstance().getConnection()){
            List<CartItem> cartItems=new ArrayList<>();
            String sql="select * from CartItem where Cart_ID =?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,cart.getId());
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int cartitemid=resultSet.getInt(1);
                int quantity=resultSet.getInt(2);
                float total=resultSet.getFloat(3);
                int productid=resultSet.getInt(4);
                Product product=new Product();
                product.setProduct_id(productid);
                CartItem cartItem=new CartItem(cartitemid,quantity,cart.getId(),product,total);
                cartItems.add(cartItem);
            }
            return cartItems;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean checkCartItemAlreadyInCart(CartItem cartItem) {
        try(Connection connection=DBUtil.getInstance().getConnection()){
            String sql="select * from CartItem where Product_ID=? AND Cart_ID=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,cartItem.getProduct().getProduct_id());
            preparedStatement.setInt(2,cartItem.getCart_id());
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
