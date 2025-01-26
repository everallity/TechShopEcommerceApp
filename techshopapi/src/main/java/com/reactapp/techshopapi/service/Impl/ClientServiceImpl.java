package com.reactapp.techshopapi.service.Impl;

import com.reactapp.techshopapi.model.Account;
import com.reactapp.techshopapi.model.Client;
import com.reactapp.techshopapi.respositories.ClientDAO;
import com.reactapp.techshopapi.respositories.Impl.ClientDAOImpl;
import com.reactapp.techshopapi.service.ClientService;

public class ClientServiceImpl implements ClientService {
    private static ClientDAO clientDAO=new ClientDAOImpl();
    @Override
    public Client getClientinfo(Account account) {
        return clientDAO.getClientbyAccountID(account.getId());
    }

    @Override
    public boolean editClient(Client client) {
        return clientDAO.updateClient(client);
    }
}
