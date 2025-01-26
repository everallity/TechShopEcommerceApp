package com.reactapp.techshopapi.respositories;

import com.reactapp.techshopapi.model.Client;

import java.util.List;

public interface ClientDAO {
    public boolean addClient(Client client);
    public boolean deleteClient(Client client);
    public boolean updateClient(Client client);
    public List<Client> getListClient();
    public Client getlastClient();
    public Client getClientbyAccountID(int account_id);
    public Client getClientbyClientID(int client_id);
}
