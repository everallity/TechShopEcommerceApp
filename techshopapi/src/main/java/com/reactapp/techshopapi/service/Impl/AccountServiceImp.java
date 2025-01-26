package com.reactapp.techshopapi.service.Impl;

import com.reactapp.techshopapi.model.Account;
import com.reactapp.techshopapi.model.Cart;
import com.reactapp.techshopapi.model.Client;
import com.reactapp.techshopapi.model.Staff;
import com.reactapp.techshopapi.model.dto.LoginCredential;
import com.reactapp.techshopapi.respositories.AccountDAO;
import com.reactapp.techshopapi.respositories.CartDAO;
import com.reactapp.techshopapi.respositories.ClientDAO;
import com.reactapp.techshopapi.respositories.Impl.AccountDAOImpl;
import com.reactapp.techshopapi.respositories.Impl.CartDAOImpl;
import com.reactapp.techshopapi.respositories.Impl.ClientDAOImpl;
import com.reactapp.techshopapi.respositories.Impl.StaffDAOImpl;
import com.reactapp.techshopapi.respositories.StaffDAO;
import com.reactapp.techshopapi.service.AccountService;

import java.util.List;

public class AccountServiceImp implements AccountService {
    private AccountDAO accountDAO=new AccountDAOImpl();
    private StaffDAO staffDAO=new StaffDAOImpl();
    private ClientDAO clientDAO=new ClientDAOImpl();
    private CartDAO cartDAO=new CartDAOImpl();
    @Override
    public Account checkLogin(LoginCredential loginCredential) {
        Account account=accountDAO.getAccountbyCredentials(loginCredential.getEmail(),loginCredential.getPw(),loginCredential.getType());
        return account;
    }

    @Override
    public boolean changePassword(Account account) {
        try {
            accountDAO.updateAccountbyId(account);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean signUp(Account account) {
        if(accountDAO.checkEmailAvailability(account.getEmail())){
            return false;
        }else {
            accountDAO.add(account);
            Account newacc=accountDAO.getlastAccount();
            Client newclient=new Client();
            newclient.setAccount_id(newacc.getId());
            clientDAO.addClient(newclient);
            Client newestClient=clientDAO.getlastClient();
            Cart cart=new Cart();
            cart.setClientid(newestClient.getClient_id());
            cartDAO.addCart(cart);
            return true;
        }
    }

    @Override
    public boolean signupStaff(Account account) {
        if(accountDAO.checkEmailAvailability(account.getEmail())){
            return false;
        }else {
            accountDAO.add(account);
            Account newacc=accountDAO.getlastAccount();
            Staff newstaff=new Staff();
            newstaff.setAccount_id(newacc.getId());
            staffDAO.addStaff(newstaff);
            return true;
        }
    }

    @Override
    public List<Staff> getListStaff() {
        return staffDAO.getListStaff();
    }
}
