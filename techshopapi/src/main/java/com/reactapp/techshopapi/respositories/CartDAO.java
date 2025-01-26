package com.reactapp.techshopapi.respositories;

import com.reactapp.techshopapi.model.Cart;
import com.reactapp.techshopapi.model.Client;

public interface CartDAO {
    public boolean addCart(Cart cart);
    public Cart getCartofClient(Client client);
    public boolean updateCart(Cart cart);
    public Cart getCartbyID(int cartid);
}
