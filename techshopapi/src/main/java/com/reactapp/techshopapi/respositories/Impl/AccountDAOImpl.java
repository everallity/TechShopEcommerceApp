package com.reactapp.techshopapi.respositories.Impl;

import com.reactapp.techshopapi.Util.DBUtil;
import com.reactapp.techshopapi.Util.HibernateUtil;
import com.reactapp.techshopapi.model.Account;
import com.reactapp.techshopapi.respositories.AccountDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {
    @Override
    public boolean add(Account account) {
     /*   try(SessionFactory sessionFactory=HibernateUtil.getSessionFactory()) {
            Session session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            session.save(account);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }*/
        try(Connection connection=DBUtil.getInstance().getConnection()){
            String sql="insert into Account(Username,Email,Password,Type) values (?,?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2,account.getEmail());
            preparedStatement.setString(3,account.getPassword());
            preparedStatement.setInt(4,account.getType());
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
    public Account getAccountbyId(int id) {
     /*   try(SessionFactory sessionFactory=HibernateUtil.getSessionFactory()){
            Session session=sessionFactory.openSession();
            Transaction transaction= session.beginTransaction();
            String hql="From Account Where Account_id = ?";

            Query<Account> query=session.createQuery(hql,Account.class);
            List<Account> accountList=query.getResultList();
            Account account=accountList.get(0);
            transaction.commit();
            session.close();
            return account;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }*/
        return null;
    }

    @Override
    public boolean deleteAccountbyId(int id) {
    /*    try(SessionFactory sessionFactory=HibernateUtil.getSessionFactory()){
            Session session=sessionFactory.openSession();
            Transaction transaction= session.beginTransaction();
            String hql="Delete from Account where Account_id=:id";
            Query query=session.createQuery(hql);
            query.setParameter("id",id);
            int status=query.executeUpdate();
            session.close();
            if (status>0){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }*/
        return false;
    }

    @Override
    public boolean updateAccountbyId(Account account) {
     /*   SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=null;
        try {
            transaction=session.beginTransaction();
            String hql="Update Account Set Username=:un,Email=:email,Password=:pw where Account_id=:id";
            Query query=session.createQuery(hql);
            query.setParameter("un",account.getUsername());
            query.setParameter("email",account.getEmail());
            query.setParameter("pw",account.getPassword());
            int status=query.executeUpdate();
            session.close();
            transaction.commit();
            if(status>0){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }*/
        return false;
    }

    @Override
    public Account getAccountbyCredentials(String email, String password,int type) {
       /* try(SessionFactory sessionFactory=HibernateUtil.getSessionFactory()){
            Account account=new Account();
            Session session=sessionFactory.openSession();
            Transaction transaction= session.beginTransaction();
            String hql="From Account Where Email = :email And Password=:pw";
            Query query=session.createQuery(hql);
            query.setParameter("email",email);
            query.setParameter("pw",password);
            List<Account> accountList=query.getResultList();
            if(accountList.size()>0){
                account=accountList.get(0);
            }
            transaction.commit();
            session.close();
            return account;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }*/
        try(Connection connection= DBUtil.getInstance().getConnection()){
            String sql="Select * from Account where Email=? AND Password =? AND Type=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
            preparedStatement.setInt(3,type);
            ResultSet resultSet=preparedStatement.executeQuery();

            if(resultSet.next()){
                int accountid=resultSet.getInt(1);
                String mail=resultSet.getString(3);
                String pw=resultSet.getString(4);
                String un=resultSet.getString(2);
                Account account=new Account(un,mail,pw,accountid,type);
                return account;
            }
            return null;


        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean checkEmailAvailability(String email) {
       /* try(SessionFactory sessionFactory=HibernateUtil.getSessionFactory()){
            Session session=sessionFactory.openSession();
            Transaction transaction= session.beginTransaction();
            String hql="From Account where Email=:email";
            Query query=session.createQuery(hql);
            query.setParameter("email",email);
            List<Account> accountList=query.getResultList();
            if(accountList.size()>0)
                return true;
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }*/
        try(Connection connection=DBUtil.getInstance().getConnection()){
            String sql="select * from Account where Email=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,email);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean checkUNAvailability(String username) {
     /*   try(SessionFactory sessionFactory=HibernateUtil.getSessionFactory()){
            Session session=sessionFactory.openSession();
            Transaction transaction= session.beginTransaction();
            String hql="From Account where Username=:un";
            Query query=session.createQuery(hql);
            query.setParameter("un",username);
            List<Account> accountList=query.getResultList();
            if(accountList.size()>0)
                return true;
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }*/
        return false;
    }

    @Override
    public Account getlastAccount() {
        try(Connection connection=DBUtil.getInstance().getConnection()){
            String sql="select * from Account order by Account_ID desc limit 1";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.next();
            int account_id=resultSet.getInt(1);
            Account account=new Account();
            account.setId(account_id);
            return account;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
