package com.reactapp.techshopapi.respositories;

import com.reactapp.techshopapi.model.Cart;
import com.reactapp.techshopapi.model.CartItem;

import java.util.List;

public interface CartItemDAO {
    public boolean addCartItem(CartItem cartItem);
    public boolean deleteCartItem(CartItem cartItem);
    public boolean updateCartItem(CartItem cartItem);
    public List<CartItem> getListCartItemofCart(Cart cart);
    public boolean checkCartItemAlreadyInCart(CartItem cartItem);
}
