package com.reactapp.techshopapi.service;

import com.reactapp.techshopapi.model.Account;
import com.reactapp.techshopapi.model.Cart;
import com.reactapp.techshopapi.model.CartItem;
import com.reactapp.techshopapi.model.Client;

public interface CartService {
    public boolean addItemtoCart(int account_id,int product_id);
    public boolean increaseIteminCart(CartItem cartItem);
    public boolean decreaseIteminCart(CartItem cartItem);
    public boolean deleteIteminCart(CartItem cartItem);
    public Cart getClientCart(Account account);
}
