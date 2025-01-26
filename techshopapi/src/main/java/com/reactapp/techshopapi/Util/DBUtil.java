package com.reactapp.techshopapi.Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    private static DBUtil instance;
    public static DBUtil getInstance(){
        return  instance=instance!=null?instance:new DBUtil();
    }
    public Connection getConnection(){
        try{
            String dbUrl="jdbc:mysql://localhost:3306/techshop?allowPublicKeyRetrieval=true&useSSL=false";
            String dbClass="com.mysql.cj.jdbc.Driver";
            String un="root";
            String pw="Abcd1234";
            Class.forName(dbClass);
            return DriverManager.getConnection(dbUrl,un,pw);

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
