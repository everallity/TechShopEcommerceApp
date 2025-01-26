package com.reactapp.techshopapi.service.Impl;

import com.reactapp.techshopapi.model.Order;
import com.reactapp.techshopapi.model.OrderItem;
import com.reactapp.techshopapi.model.Product;
import com.reactapp.techshopapi.model.ProductStat;
import com.reactapp.techshopapi.respositories.Impl.OrderDAOImpl;
import com.reactapp.techshopapi.respositories.Impl.OrderItemDAOImpl;
import com.reactapp.techshopapi.respositories.Impl.ProductDAOImpl;
import com.reactapp.techshopapi.respositories.OrderDAO;
import com.reactapp.techshopapi.respositories.OrderItemDAO;
import com.reactapp.techshopapi.respositories.ProductDAO;
import com.reactapp.techshopapi.service.ProductStatService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductStatServiceImpl implements ProductStatService {
    private static OrderItemDAO orderItemDAO=new OrderItemDAOImpl();
    private static ProductDAO productDAO=new ProductDAOImpl();
    private static OrderDAO orderDAO=new OrderDAOImpl();
    @Override
    public List<ProductStat> getListProductStatbyDate(String startdate, String enddate) {
        try{
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Date sdate=sdf.parse(startdate);
            Date edate=sdf.parse(enddate);
            List<ProductStat> productStats=new ArrayList<>();
            List<Product> products=productDAO.getListProduct();
            List<OrderItem> orderItems=orderItemDAO.getListOrderItem();
            List<Order> orders=orderDAO.getListOrder();
            // lọc ra các order trong khoảng ngày
            List<Order> filterlist=new ArrayList<>();
            for(Order o:orders){
                Date createat=sdf.parse(o.getCreate_at());
                if(createat.after(edate)||createat.before(sdate)){
                    filterlist.add(o);
                }
            }
            orders.removeAll(filterlist);
            //
            // lọc ra các orderitem trong khoảng ngày
            List<OrderItem> oitemfilter=new ArrayList<>();
            for(OrderItem oi:orderItems){
                for(Order o:orders){
                    if(oi.getOrderid()==o.getId()){
                        oitemfilter.add(oi);
                        break;
                    }
                }
            }
            //
            // từ oitemfilter tạo ra productstat
           /* for(OrderItem o:oitemfilter){
                Product product=productDAO.getProductbyId(o.getProduct().getProduct_id());
                ProductStat productStat=new ProductStat(product.getProduct_id(),product.getStock(),product.getName(),product.getBrand(),
                        product.getCategory(),product.getImage(),product.getDescription(),product.getPrice()) ;

                productStats.add(productStat);
            }*/
            for(Product product:products){
                ProductStat productStat=new ProductStat(product.getProduct_id(),product.getStock(),product.getName(),product.getBrand(),
                        product.getCategory(),product.getImage(),product.getDescription(),product.getPrice()) ;
                int numbersold=0;
                float revenue=0;
                for(OrderItem o:oitemfilter){
                    if(o.getProduct().getProduct_id()==product.getProduct_id()){
                        numbersold=numbersold+o.getQuantity();
                        revenue=revenue+o.getTotalamount();
                    }
                }
                productStat.setRevenue(revenue);
                productStat.setNumbersold(numbersold);
                productStats.add(productStat);
            }


            return productStats;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Order> getProductStatDetail(int productid,String startdate,String enddate) {
        try{
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Date edate=sdf.parse(enddate);
            Date sdate=sdf.parse(startdate);
            List<Order> orders=new ArrayList<>();
            List<Order> filterlist=new ArrayList<>();
            List<OrderItem> orderItems=orderItemDAO.getListOrderItembyProductID(productid);
            for(OrderItem o:orderItems){
                Order order=orderDAO.getOrderbyID(o.getOrderid());
                orders.add(order);
            }
            // lọc ra các order trong khoảng ngày
            for(Order o:orders){
                Date createat=sdf.parse(o.getCreate_at());
                if(createat.after(edate)||createat.before(sdate)){
                    filterlist.add(o);
                }
            }
            orders.removeAll(filterlist);
            //
            return orders;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
