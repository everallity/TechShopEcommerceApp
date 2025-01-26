package com.reactapp.techshopapi.controller;

import com.reactapp.techshopapi.model.Order;
import com.reactapp.techshopapi.model.ProductStat;
import com.reactapp.techshopapi.service.Impl.ProductStatServiceImpl;
import com.reactapp.techshopapi.service.ProductStatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("productstat/")
@CrossOrigin
public class ProductStatController {
    private static final ProductStatService productStatService= new ProductStatServiceImpl();

    @PostMapping(value = "getlistproductstat",consumes = "multipart/form-data",produces = "application/json")
    @ResponseBody
    public List<ProductStat> getListProductStat(String sdate,String edate){
        return productStatService.getListProductStatbyDate(sdate,edate);
    }

    @PostMapping(value = "getproductstatdetail",consumes = "multipart/form-data",produces = "application/json")
    @ResponseBody
    public List<Order> getProductStatDetail(@RequestParam("product_id")int productid,
                                            @RequestParam("sdate")String startdate,
                                            @RequestParam("edate")String enddate){
        return productStatService.getProductStatDetail(productid,startdate,enddate);
    }
}
