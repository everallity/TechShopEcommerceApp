package com.reactapp.techshopapi.respositories.Impl.unused;

import com.reactapp.techshopapi.Util.DBUtil;
import com.reactapp.techshopapi.model.unused.Phone;
import com.reactapp.techshopapi.respositories.unused.PhoneDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PhoneDAOImpl implements PhoneDAO {
    @Override
    public boolean add(Phone phone) {
        return false;
    }

    @Override
    public boolean delete(Phone phone) {
        return false;
    }

    @Override
    public boolean update(Phone phone) {
        return false;
    }

    @Override
    public List<Phone> getListPhone() {
        //private String size,display,weight,battery,processor,camera;
        try(Connection connection= DBUtil.getInstance().getConnection()) {
            List<Phone> phones=new ArrayList<>();
            String sql="Select * from Phone";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String size=resultSet.getString(1);
                String display=resultSet.getString(2);
                String weight=resultSet.getString(3);
                String battery=resultSet.getString(4);
                String processor=resultSet.getString(5);
                String camera=resultSet.getString(6);
                int phone_id=resultSet.getInt(0);
                Phone phone=new Phone(size,display,weight,battery,processor,camera,phone_id);
                phones.add(phone);
            }
            return phones;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
