package com.reactapp.techshopapi.respositories.Impl.unused;

import com.reactapp.techshopapi.Util.DBUtil;
import com.reactapp.techshopapi.model.unused.PC;
import com.reactapp.techshopapi.respositories.unused.PCDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PCDAOImpl implements PCDAO {
    @Override
    public boolean add(PC pc) {
        return false;
    }

    @Override
    public boolean delete(PC pc) {
        return false;
    }

    @Override
    public boolean update(PC pc) {
        return false;
    }

    @Override
    public List<PC> getListPC() {
        //private String pccase,motherboard,opsys,processor,cooling,memory,gcard,storage;
        try(Connection connection= DBUtil.getInstance().getConnection()) {
            List<PC> pcList=new ArrayList<>();
            String sql="Select * from PC";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String pccase=resultSet.getString(1);
                String motherboard=resultSet.getString(2);
                String opsys=resultSet.getString(3);
                String processor=resultSet.getString(4);
                String cooling=resultSet.getString(5);
                String memory=resultSet.getString(6);
                String gcard=resultSet.getString(7);
                String storage=resultSet.getString(8);
                int pc_id=resultSet.getInt(0);
                PC pc=new PC(pccase,motherboard,opsys,processor,cooling,memory,gcard,storage,pc_id);
                pcList.add(pc);
            }
            return pcList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
