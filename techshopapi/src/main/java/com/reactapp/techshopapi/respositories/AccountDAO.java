package com.reactapp.techshopapi.respositories;

import com.reactapp.techshopapi.model.Account;

public interface AccountDAO {
    public boolean add(Account account);
    public Account getAccountbyId(int id);
    public boolean deleteAccountbyId(int id);
    public boolean updateAccountbyId(Account account);
    public Account getAccountbyCredentials(String email,String password,int type);
    public boolean checkEmailAvailability(String email);
    public boolean checkUNAvailability(String username);
    public Account getlastAccount();
}
