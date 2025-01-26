package com.reactapp.techshopapi.service;

import com.reactapp.techshopapi.model.Order;
import com.reactapp.techshopapi.model.ProductStat;

import java.util.List;

public interface ProductStatService {
    public List<ProductStat> getListProductStatbyDate(String startdate, String enddate);
    public List<Order> getProductStatDetail(int productid,String startdate,String enddate);
}
