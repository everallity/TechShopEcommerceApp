package com.reactapp.techshopapi.service.Impl;

import com.reactapp.techshopapi.model.*;
import com.reactapp.techshopapi.respositories.CartDAO;
import com.reactapp.techshopapi.respositories.CartItemDAO;
import com.reactapp.techshopapi.respositories.ClientDAO;
import com.reactapp.techshopapi.respositories.Impl.CartDAOImpl;
import com.reactapp.techshopapi.respositories.Impl.CartItemDAOImpl;
import com.reactapp.techshopapi.respositories.Impl.ClientDAOImpl;
import com.reactapp.techshopapi.respositories.Impl.ProductDAOImpl;
import com.reactapp.techshopapi.respositories.ProductDAO;
import com.reactapp.techshopapi.service.CartService;
import org.hibernate.dialect.aggregate.DB2AggregateSupport;

import java.sql.Connection;
import java.util.List;

public class CartServiceImpl implements CartService {
    private CartItemDAO cartItemDAO=new CartItemDAOImpl();
    private ProductDAO productDAO=new ProductDAOImpl();
    private ClientDAO clientDAO=new ClientDAOImpl();
    private CartDAO cartDAO=new CartDAOImpl();
    @Override
    public boolean addItemtoCart(int account_id,int product_id) {
        CartItem cartItem=new CartItem();
        cartItem.setQuantity(1);
        Product product=productDAO.getProductbyId(product_id);
        cartItem.setTotalamount(product.getPrice());
        Client client=clientDAO.getClientbyAccountID(account_id);
        Cart cart=cartDAO.getCartofClient(client);
        cartItem.setCart_id(cart.getId());
        cartItem.setProduct(product);
        cart.setFinal_amount(cart.getFinal_amount()+cartItem.getTotalamount());
        if(cartItemDAO.checkCartItemAlreadyInCart(cartItem)){
            return false;
        }
        cartDAO.updateCart(cart);
        return cartItemDAO.addCartItem(cartItem);
    }

    @Override
    public boolean increaseIteminCart(CartItem cartItem) {

        int quantity=cartItem.getQuantity()+1;
        cartItem.setQuantity(quantity);
        Product product=productDAO.getProductbyId(cartItem.getProduct().getProduct_id());
        float total_amount=product.getPrice()+cartItem.getTotalamount();
        cartItem.setTotalamount(total_amount);
        Cart cart=cartDAO.getCartbyID(cartItem.getCart_id());
        float final_amount=cart.getFinal_amount() + product.getPrice();
        cart.setFinal_amount(final_amount);
        cartDAO.updateCart(cart);
        return cartItemDAO.updateCartItem(cartItem);
    }

    @Override
    public boolean decreaseIteminCart(CartItem cartItem) {
        int quantity=cartItem.getQuantity()-1;
        if(quantity==0){
            return deleteIteminCart(cartItem);
        }
        cartItem.setQuantity(quantity);
        Product product=productDAO.getProductbyId(cartItem.getProduct().getProduct_id());
        float total_amount=cartItem.getTotalamount()-product.getPrice();
        cartItem.setTotalamount(total_amount);
        Cart cart=cartDAO.getCartbyID(cartItem.getCart_id());
        float final_amount=cart.getFinal_amount() - product.getPrice();
        cart.setFinal_amount(final_amount);
        cartDAO.updateCart(cart);
        return cartItemDAO.updateCartItem(cartItem);
    }

    @Override
    public boolean deleteIteminCart(CartItem cartItem) {
        float totalamount=cartItem.getTotalamount();
        Cart cart=cartDAO.getCartbyID(cartItem.getCart_id());
        float final_amount=cart.getFinal_amount()-totalamount;
        cart.setFinal_amount(final_amount);
        cartDAO.updateCart(cart);
        return cartItemDAO.deleteCartItem(cartItem);
    }

    @Override
    public Cart getClientCart(Account account) {
        Client client=clientDAO.getClientbyAccountID(account.getId());
        Cart cart=cartDAO.getCartofClient(client);
        List<CartItem> cartItems=cartItemDAO.getListCartItemofCart(cart);
        for(CartItem cartItem:cartItems){
            cartItem.setProduct(productDAO.getProductbyId(cartItem.getProduct().getProduct_id()));
        }
        cart.setCartItemList(cartItems);
        return cart;
    }


}
