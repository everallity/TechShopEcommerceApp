package com.reactapp.techshopapi.controller;

import com.reactapp.techshopapi.model.Account;
import com.reactapp.techshopapi.model.Cart;
import com.reactapp.techshopapi.model.Order;
import com.reactapp.techshopapi.service.Impl.OrderServiceImpl;
import com.reactapp.techshopapi.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order/")
@CrossOrigin
public class OrderController {
    private static final OrderService orderService=new OrderServiceImpl();

    @PostMapping(value = "addorder",consumes = "multipart/form-data",produces = "application/json")
    @ResponseBody
    public boolean addOrder(@RequestParam("id") int id,
                            @RequestParam("clientid") int clientid,
                            @RequestParam("final_amount")float amount,
                            @RequestParam("address")String address){
        Cart cart=new Cart();
        cart.setFinal_amount(amount);
        cart.setClientid(clientid);
        cart.setId(id);
        return orderService.addOrder(cart,address);
    }

    @GetMapping(value = "getlistorder",produces = "application/json")
    @ResponseBody
    public List<Order> getListOrder(){
        return orderService.getListOrder();
    }
    @PostMapping("deleteorder")
    @ResponseBody
    public boolean deleteorder (@RequestBody Order order){
        return orderService.deleteOrder(order);
    }

    @PostMapping(value = "editorder",consumes ="multipart/form-data" ,produces ="application/json" )
    @ResponseBody
    public boolean editorder(@RequestParam("clientid")int clientid,
                             @RequestParam("id")int id,
                             @RequestParam("create_at")String createat,
                             @RequestParam("order_status")String status,
                             @RequestParam("shipping_address")String address,
                             @RequestParam("shipping_fee")float fee,
                             @RequestParam("total_amount")float amount
                             ){
        Order order=new Order(id,clientid,address,status,fee,amount,createat);
        return orderService.editOrder(order);
    }

    @PostMapping(value = "getlistorderofclient",consumes ="multipart/form-data" ,produces ="application/json" )
    @ResponseBody
    public List<Order> getlistorderofclient(@RequestParam("email") String email,
                                            @RequestParam("password") String password,
                                            @RequestParam("type") int type,
                                            @RequestParam("username") String user,
                                            @RequestParam("id") int id) {
        Account account=new Account(user,email,password,id,type);
        return orderService.getListOrderofClient(account);
    }
}
