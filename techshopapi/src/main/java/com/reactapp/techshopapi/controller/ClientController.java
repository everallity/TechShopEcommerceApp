package com.reactapp.techshopapi.controller;

import com.reactapp.techshopapi.model.Account;
import com.reactapp.techshopapi.model.Client;
import com.reactapp.techshopapi.service.ClientService;
import com.reactapp.techshopapi.service.Impl.ClientServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("client/")
@CrossOrigin
public class ClientController {
    private static final ClientService clientService=new ClientServiceImpl();

    @PostMapping(value = "getclientbyaccount",consumes = "multipart/form-data",produces = "application/json")
    @ResponseBody
    public Client getClientbyAccount(@RequestParam("email")String email,
                                     @RequestParam("id")int id,
                                     @RequestParam("username")String username,
                                     @RequestParam("password")String password,
                                     @RequestParam("type")int type){
        Account account=new Account(username,email,password,id,type
        );
        return clientService.getClientinfo(account);
    }

    @PostMapping(value = "editclient",consumes = "multipart/form-data",produces = "application/json")
    @ResponseBody
    public boolean editClient(@RequestParam("name")String name,
                              @RequestParam("address")String address,
                              @RequestParam("dob")String dob,
                              @RequestParam("phone")String phone,
                              @RequestParam("gender")String gender,
                              @RequestParam("id")int id){
        Client client=new Client();
        client.setClient_id(id);
        client.setPhone(phone);
        client.setAddress(address);
        client.setDob(dob);
        client.setGender(gender);
        client.setName(name);
        System.out.println(client);
        return clientService.editClient(client);
    }

}
