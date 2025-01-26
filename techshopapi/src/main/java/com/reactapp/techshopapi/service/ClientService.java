package com.reactapp.techshopapi.service;

import com.reactapp.techshopapi.model.Account;
import com.reactapp.techshopapi.model.Client;

public interface ClientService {
    public Client getClientinfo(Account account);
    public boolean editClient(Client client);
}
