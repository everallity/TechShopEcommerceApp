package com.reactapp.techshopapi.respositories.Impl.unused;

import com.reactapp.techshopapi.Util.DBUtil;
import com.reactapp.techshopapi.model.unused.Console;
import com.reactapp.techshopapi.respositories.unused.ConsoleDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ConsoleDAOImpl implements ConsoleDAO {
    @Override
    public boolean add(Console console) {
        return false;
    }

    @Override
    public boolean delete(Console console) {
        return false;
    }

    @Override
    public boolean update(Console console) {
        return false;
    }

    @Override
    public List<Console> getListConsole() {
        // private String cpu,gpu,ram,storage;
        try(Connection connection= DBUtil.getInstance().getConnection()) {
            List<Console> consoles=new ArrayList<>();
            String sql="Select * from Console";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String cpu=resultSet.getString(1);
                String gpu=resultSet.getString(2);
                String ram=resultSet.getString(3);
                String storage=resultSet.getString(4);
                int console_id=resultSet.getInt(0);
                Console console=new Console(cpu,gpu,ram,storage,console_id);
                consoles.add(console);
            }
            return consoles;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
