package com.reactapp.techshopapi.controller;

import com.reactapp.techshopapi.model.Account;
import com.reactapp.techshopapi.model.Cart;
import com.reactapp.techshopapi.model.CartItem;
import com.reactapp.techshopapi.model.Product;
import com.reactapp.techshopapi.service.CartService;
import com.reactapp.techshopapi.service.Impl.CartServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cart/")
@CrossOrigin
public class CartController {
    private static final CartService cartService=new CartServiceImpl();
    @PostMapping(value = "additemtocart",consumes = "multipart/form-data",produces = "application/json")
    @ResponseBody
    public boolean addItemtoCart(@RequestParam("id")int account_id,
                                 @RequestParam("product_id") int product_id){
        return cartService.addItemtoCart(account_id,product_id);
    }

    @PostMapping(value ="getcartofclient",consumes = "multipart/form-data",produces = "application/json")
    @ResponseBody
    public Cart getCartofClient(@RequestParam("id") int id,
                                @RequestParam("email") String email,
                                @RequestParam("password") String pw,
                                @RequestParam("type") int type,
                                @RequestParam("username") String un){
        Account account=new Account(un,email,pw,id,type);
        return cartService.getClientCart(account);
    }
    @PostMapping(value = "decreasecartitem",consumes = "multipart/form-data",produces = "application/json")
    @ResponseBody
    public  boolean decreaseIteminCart(@RequestParam("cart_id") int cartid,
                                       @RequestParam("quantity") int quantity,
                                       @RequestParam("id") int id,
                                       @RequestParam("product_id") int productid,
                                       @RequestParam("totalamount") float total){
        CartItem cartItem=new CartItem();
        cartItem.setCart_id(cartid);
        cartItem.setTotalamount(total);
        cartItem.setQuantity(quantity);
        cartItem.setId(id);
        Product product=new Product();
        product.setProduct_id(productid);
        cartItem.setProduct(product);
        return cartService.decreaseIteminCart(cartItem);
    }

    @PostMapping(value = "increasecartitem",produces = "application/json")
    @ResponseBody
    public boolean increaseIteminCart(@RequestParam("cart_id") int cartid,
                                      @RequestParam("quantity") int quantity,
                                      @RequestParam("id") int id,
                                      @RequestParam("product_id") int productid,
                                      @RequestParam("totalamount") float total){
        CartItem cartItem=new CartItem();
        cartItem.setCart_id(cartid);
        cartItem.setTotalamount(total);
        cartItem.setQuantity(quantity);
        cartItem.setId(id);
        Product product=new Product();
        product.setProduct_id(productid);
        cartItem.setProduct(product);
        return cartService.increaseIteminCart(cartItem);
    }

    @PostMapping(value = "deletecartitem",produces = "application/json")
    @ResponseBody
    public boolean deleteCartItem(@RequestParam("cart_id") int cartid,
                                  @RequestParam("quantity") int quantity,
                                  @RequestParam("id") int id,
                                  @RequestParam("product_id") int productid,
                                  @RequestParam("totalamount") float total){
        CartItem cartItem=new CartItem();
        cartItem.setCart_id(cartid);
        cartItem.setTotalamount(total);
        cartItem.setQuantity(quantity);
        cartItem.setId(id);
        Product product=new Product();
        product.setProduct_id(productid);
        cartItem.setProduct(product);
        return cartService.deleteIteminCart(cartItem);
    }
}
