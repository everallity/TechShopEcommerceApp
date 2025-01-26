package com.reactapp.techshopapi.controller;
import com.reactapp.techshopapi.model.Account;
import com.reactapp.techshopapi.model.Staff;
import com.reactapp.techshopapi.model.dto.LoginCredential;
import com.reactapp.techshopapi.service.AccountService;
import com.reactapp.techshopapi.service.Impl.AccountServiceImp;
import jdk.jfr.ContentType;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;

@RestController
@RequestMapping("account/")
@CrossOrigin
public class AccountController {
    private static final AccountService accountService=new AccountServiceImp();

    @PostMapping(value = "login",consumes = "multipart/form-data",produces = "application/json")
    @ResponseBody
    @CrossOrigin
    public Account checkLogin(@RequestParam("email") String email,
                              @RequestParam("pw") String pw,
                              @RequestParam("type") int type){
        LoginCredential loginCredential=new LoginCredential(email,pw,type);
        System.out.println(accountService.checkLogin(loginCredential));
        System.out.println(loginCredential);
        return accountService.checkLogin(loginCredential);
    }

    @GetMapping(value = "staff/getliststaff",produces ="application/json")
    @ResponseBody
    public List<Staff> getListStaff(){
        return accountService.getListStaff();
    }

    @PostMapping(value = "signupstaff",consumes = "multipart/form-data",produces ="application/json" )
    @ResponseBody
    public  boolean createAccountStaff(@RequestParam("email") String email,
                                  @RequestParam("pw") String password,
                                  @RequestParam("type") int type,
                                  @RequestParam("username") String user){
        Account account=new Account();
        account.setEmail(email);
        account.setPassword(password);
        account.setType(type);
        account.setUsername(user);
        return accountService.signupStaff(account);
    }
    @PostMapping(value = "signup",consumes = "multipart/form-data",produces ="application/json" )
    @ResponseBody
    public  boolean createAccountClient(@RequestParam("email") String email,
                                       @RequestParam("pw") String password,
                                       @RequestParam("type") int type,
                                       @RequestParam("username") String user){
        Account account=new Account();
        account.setEmail(email);
        account.setPassword(password);
        account.setType(type);
        account.setUsername(user);
        return accountService.signUp(account);
    }
}
