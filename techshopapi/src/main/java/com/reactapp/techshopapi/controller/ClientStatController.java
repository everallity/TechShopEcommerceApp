package com.reactapp.techshopapi.controller;

import com.reactapp.techshopapi.model.ClientStat;
import com.reactapp.techshopapi.model.Order;
import com.reactapp.techshopapi.service.ClientStatService;
import com.reactapp.techshopapi.service.Impl.ClientStatServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientstat/")
@CrossOrigin
public class ClientStatController {
    private static final ClientStatService clientStatService=new ClientStatServiceImpl();
    @PostMapping(value ="getlistclientstat" ,consumes ="multipart/form-data" ,produces = "application/json")
    @ResponseBody
    public List<ClientStat> getListClientStat(String sdate,String edate){
        return clientStatService.getListClientStatbyDate(sdate,edate);
    }
    @PostMapping(value = "getclientstatdetail",consumes = "multipart/form-data",produces = "application/json")
    @ResponseBody
    public List<Order> getClientStatDetail(@RequestParam("client_id")int clientid,
                                            @RequestParam("sdate")String startdate,
                                            @RequestParam("edate")String enddate){
        return clientStatService.getClientStatDetail(clientid,startdate,enddate);
    }
}
