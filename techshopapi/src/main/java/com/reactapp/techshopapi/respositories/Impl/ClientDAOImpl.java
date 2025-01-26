package com.reactapp.techshopapi.respositories.Impl;

import com.reactapp.techshopapi.Util.DBUtil;
import com.reactapp.techshopapi.model.Account;
import com.reactapp.techshopapi.model.Client;
import com.reactapp.techshopapi.respositories.ClientDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClientDAOImpl implements ClientDAO {
    @Override
    public boolean addClient(Client client) {
        try(Connection connection= DBUtil.getInstance().getConnection()) {
            String sql="insert into Client(Account_ID) values (?)";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,client.getAccount_id());
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
    public boolean deleteClient(Client client) {
        return false;
    }

    @Override
    public boolean updateClient(Client client) {
        try(Connection connection=DBUtil.getInstance().getConnection()){
            String sql="update Client set Name=?," +
                    "Address=?," +
                    "Phone=?," +
                    "Gender=?," +
                    "Dob=? where Client_ID=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setNString(1,client.getName());
            preparedStatement.setNString(2,client.getAddress());
            preparedStatement.setString(3,client.getPhone());
            preparedStatement.setNString(4,client.getGender());
            preparedStatement.setString(5,client.getDob());
            preparedStatement.setInt(6,client.getClient_id());
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
    public List<Client> getListClient() {
        try(Connection connection=DBUtil.getInstance().getConnection()){
            String sql="select * from Client";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            List<Client> clients=new ArrayList<>();
            while (resultSet.next()){
                int client_id=resultSet.getInt(1);
                String name=resultSet.getNString(2);
                String address=resultSet.getNString(3);
                String phone=resultSet.getString(4);
                String gender=resultSet.getNString(5);
                String dob=resultSet.getString(6);
                int account_id=resultSet.getInt(7);
                Client client=new Client(client_id,account_id,name,address,phone,gender,dob);
                clients.add(client);
            }
            return clients;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Client getlastClient() {
        try(Connection connection=DBUtil.getInstance().getConnection()){
            String sql="select * from Client order by Client_ID desc limit 1";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.next();
            int client_id=resultSet.getInt(1);
            Client client=new Client();
            client.setClient_id(client_id);
            return client;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Client getClientbyAccountID(int account_id) {
        try(Connection connection=DBUtil.getInstance().getConnection()){
            String sql="select * from Client where Account_ID=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,account_id);
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.next();
            int client_id=resultSet.getInt(1);
            String name=resultSet.getNString(2);
            String address=resultSet.getNString(3);
            String phone=resultSet.getString(4);
            String gender=resultSet.getNString(5);
            String dob=resultSet.getString(6);
            Client client=new Client(client_id,account_id,name,address,phone,gender,dob);
            return client;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Client getClientbyClientID(int client_id) {
        try(Connection connection=DBUtil.getInstance().getConnection()){
            String sql="select * from Client where Client_ID=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,client_id);
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.next();
            int account_id=resultSet.getInt(7);
            String name=resultSet.getNString(2);
            String address=resultSet.getNString(3);
            String phone=resultSet.getString(4);
            String gender=resultSet.getNString(5);
            String dob=resultSet.getString(6);
            Client client=new Client(client_id,account_id,name,address,phone,gender,dob);
            return client;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
