package com.reactapp.techshopapi.respositories.Impl;

import com.reactapp.techshopapi.Util.DBUtil;
import com.reactapp.techshopapi.model.Account;
import com.reactapp.techshopapi.model.Staff;
import com.reactapp.techshopapi.respositories.StaffDAO;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StaffDAOImpl implements StaffDAO {
    @Override
    public boolean addStaff(Staff staff) {
        return false;
    }

    @Override
    public boolean deleteStaff(Staff staff) {
        return false;
    }

    @Override
    public boolean updateStaff(Staff staff) {
        try(Connection connection=DBUtil.getInstance().getConnection()){
            String sql="update Staff set Name=?," +
                    "Address=?," +
                    "Dob=?," +
                    "Phone=?," +
                    "Gender=? where Staff_ID=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setNString(1,staff.getName());
            preparedStatement.setNString(2,staff.getAddress());
            preparedStatement.setString(3,staff.getDob());
            preparedStatement.setString(4,staff.getPhone());
            preparedStatement.setNString(5,staff.getGender());
            preparedStatement.setInt(6,staff.getStaff_id());
            int status=preparedStatement.executeUpdate();
            if(status==1)
                return true;
            return false;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Staff> getListStaff() {
        try(Connection connection= DBUtil.getInstance().getConnection()){
            String sql="Select * from Staff";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            List<Staff> staffs=new ArrayList<>();
            while (resultSet.next()){
                int staff_id=resultSet.getInt(1);
                String name=resultSet.getNString(2);
                String address=resultSet.getNString(3);
                String dob=resultSet.getString(4);
                String position=resultSet.getNString(5);
                String phone=resultSet.getString(6);
                String gender=resultSet.getNString(7);
                float salary=resultSet.getFloat(8);
                int account_id=resultSet.getInt(9);
                Staff staff=new Staff(account_id,staff_id,salary,name,address,dob,position,phone,gender);
                staffs.add(staff);
            }
            return staffs;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Staff getStafffromAccount(Account account) {
        try(Connection connection=DBUtil.getInstance().getConnection()){
            String sql="select * from Staff where Account_ID=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,account.getId());
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.next();
            int staff_id=resultSet.getInt(1);
            String name=resultSet.getNString(2);
            String address=resultSet.getNString(3);
            String dob=resultSet.getString(4);
            String position=resultSet.getNString(5);
            String phone=resultSet.getString(6);
            String gender=resultSet.getNString(7);
            float salary=resultSet.getFloat(8);
            Staff staff=new Staff(account.getId(),staff_id,salary,name,address,dob,position,phone,gender);
            return staff;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
