package com.reactapp.techshopapi.service;

import com.reactapp.techshopapi.model.ClientStat;
import com.reactapp.techshopapi.model.Order;

import java.util.List;

public interface ClientStatService {
    public List<ClientStat> getListClientStatbyDate(String startdate, String enddate);
    public List<Order> getClientStatDetail(int clientid,String startdate,String enddate);
}
