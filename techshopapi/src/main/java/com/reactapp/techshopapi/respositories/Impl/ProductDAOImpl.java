package com.reactapp.techshopapi.respositories.Impl;

import com.reactapp.techshopapi.Util.DBUtil;
import com.reactapp.techshopapi.model.Product;
import com.reactapp.techshopapi.respositories.ProductDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ProductDAOImpl implements ProductDAO {
    private String imgPath="http://localhost:8080/images/";
    @Override
    public boolean add(Product product) {
        try(Connection connection= DBUtil.getInstance().getConnection()){
            int status;
            String sql="insert into" +
                    " Product(Name,Brand,Category,Image,Price,Stock,Description)" +
                    " values (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setString(2, product.getBrand());
            preparedStatement.setString(3, product.getCategory());
            preparedStatement.setString(4, imgPath+product.getImage());
            preparedStatement.setFloat(5,product.getPrice());
            preparedStatement.setInt(6,product.getStock());
            preparedStatement.setString(7,product.getDescription());
            status=preparedStatement.executeUpdate();
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
    public boolean delete(Product product) {
        try(Connection connection=DBUtil.getInstance().getConnection()){
            String sql="Delete from Product where Product_ID =?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,product.getProduct_id());
            int status= preparedStatement.executeUpdate();
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
    public boolean update(Product product) {
        try(Connection connection=DBUtil.getInstance().getConnection()){
            int status=0;
            if(product.getImage().equalsIgnoreCase("")){
                String sql="Update Product set Name = ?," +
                        "Brand=?," +
                        "Category=?," +
                        "Price=?," +
                        "Stock=?," +
                        "Description=? " +
                        "Where Product_ID=?";
                PreparedStatement preparedStatement=connection.prepareStatement(sql);
                preparedStatement.setString(1,product.getName());
                preparedStatement.setString(2,product.getBrand());
                preparedStatement.setString(3,product.getCategory());
                preparedStatement.setFloat(4,product.getPrice());
                preparedStatement.setInt(5,product.getStock());
                preparedStatement.setString(6,product.getDescription());
                preparedStatement.setInt(7,product.getProduct_id());
                status=preparedStatement.executeUpdate();
            }
            else{
                String sql="Update Product set Name = ?," +
                        "Brand=?," +
                        "Category=?," +
                        "Image=?," +
                        "Price=?," +
                        "Stock=?," +
                        "Description=? " +
                        "Where Product_ID=?";
                PreparedStatement preparedStatement=connection.prepareStatement(sql);
                preparedStatement.setString(1,product.getName());
                preparedStatement.setString(2,product.getBrand());
                preparedStatement.setString(3,product.getCategory());
                preparedStatement.setString(4,imgPath+product.getImage());
                preparedStatement.setFloat(5,product.getPrice());
                preparedStatement.setInt(6,product.getStock());
                preparedStatement.setString(7,product.getDescription());
                preparedStatement.setInt(8,product.getProduct_id());
                status=preparedStatement.executeUpdate();
            }
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
    public List<Product> getListProduct() {
        //
        try(Connection connection=DBUtil.getInstance().getConnection()) {
            List<Product> products=new ArrayList<>();
            String sql="Select * from Product";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int product_id=resultSet.getInt(1);
                String name=resultSet.getString(2);
                String brand=resultSet.getString(3);
                String category=resultSet.getString(4);
                String image=resultSet.getString(5);
                String description=resultSet.getString(8);
                Float price=resultSet.getFloat(6);
                int stock=resultSet.getInt(7);
                Product product=new Product(product_id,stock,name,brand,category,image,description,price);
                products.add(product);
            }
            return products;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> getListProductbyCategory(String category) {
        try(Connection connection=DBUtil.getInstance().getConnection()){
            List<Product> products=new ArrayList<>();
            String sql="Select * from Product where Category=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,category);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int product_id=resultSet.getInt(1);
                String name=resultSet.getString(2);
                String brand=resultSet.getString(3);
                String image=resultSet.getString(5);
                String description=resultSet.getString(8);
                Float price=resultSet.getFloat(6);
                int stock=resultSet.getInt(7);
                Product product=new Product(product_id,stock,name,brand,category,image,description,price);
                products.add(product);
            }
            return products;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Product getProductbyId(int product_id) {
        try(Connection connection=DBUtil.getInstance().getConnection()){
            String sql="select * from Product where Product_ID =?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,product_id);
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.next();
            String name=resultSet.getString(2);
            String brand=resultSet.getString(3);
            String category=resultSet.getString(4);
            String image=resultSet.getString(5);
            float price=resultSet.getFloat(6);
            int stock=resultSet.getInt(7);
            String desc=resultSet.getNString(8);
            Product product=new Product(product_id,stock,name,brand,category,image,desc,price);
            return product;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
