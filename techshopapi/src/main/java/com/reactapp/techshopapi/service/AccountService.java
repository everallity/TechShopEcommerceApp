package com.reactapp.techshopapi.service;

import com.reactapp.techshopapi.model.Account;
import com.reactapp.techshopapi.model.Staff;
import com.reactapp.techshopapi.model.dto.LoginCredential;

import java.util.List;

public interface AccountService {
    public Account checkLogin(LoginCredential  loginCredential);
    public boolean  changePassword(Account account);
    public boolean signUp(Account account);
    public boolean signupStaff(Account account);
    public List<Staff> getListStaff();
}
