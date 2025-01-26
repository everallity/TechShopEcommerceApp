package com.reactapp.techshopapi.respositories.Impl.unused;

import com.reactapp.techshopapi.Util.DBUtil;
import com.reactapp.techshopapi.model.unused.Laptop;
import com.reactapp.techshopapi.respositories.unused.LaptopDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LaptopDAOImpl implements LaptopDAO {

    @Override
    public boolean add(Laptop laptop) {
        return false;
    }

    @Override
    public boolean delete(Laptop laptop) {
        return false;
    }

    @Override
    public boolean update(Laptop laptop) {
        return false;
    }

    @Override
    public List<Laptop> getListLaptop() {
        //cpu,gpu,ram,storage,battery,display,weight;
        try(Connection connection= DBUtil.getInstance().getConnection()){
            List<Laptop> laptops=new ArrayList<>();
            String sql="Select * from Laptop";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int laptop_id=resultSet.getInt(0);
                String cpu=resultSet.getString(1);
                String gpu=resultSet.getString(2);
                String ram=resultSet.getString(3);
                String storage=resultSet.getString(4);
                String battery=resultSet.getString(5);
                String display=resultSet.getString(6);
                String weight=resultSet.getString(7);
                Laptop laptop=new Laptop(cpu,gpu,ram,storage,battery,display,weight,laptop_id);
                laptops.add(laptop);
            }
            return laptops;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
