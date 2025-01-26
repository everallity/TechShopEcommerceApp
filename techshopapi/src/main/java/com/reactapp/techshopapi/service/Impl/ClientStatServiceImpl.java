package com.reactapp.techshopapi.service.Impl;

import com.reactapp.techshopapi.model.Client;
import com.reactapp.techshopapi.model.ClientStat;
import com.reactapp.techshopapi.model.Order;
import com.reactapp.techshopapi.model.OrderItem;
import com.reactapp.techshopapi.respositories.ClientDAO;
import com.reactapp.techshopapi.respositories.Impl.ClientDAOImpl;
import com.reactapp.techshopapi.respositories.Impl.OrderDAOImpl;
import com.reactapp.techshopapi.respositories.OrderDAO;
import com.reactapp.techshopapi.service.ClientStatService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientStatServiceImpl implements ClientStatService {
    private static OrderDAO orderDAO=new OrderDAOImpl();
    private static ClientDAO clientDAO=new ClientDAOImpl();
    @Override
    public List<ClientStat> getListClientStatbyDate(String startdate, String enddate) {
        try{
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            List<Client> clients=clientDAO.getListClient();
            List<ClientStat> clientStats=new ArrayList<>();
            Date sdate=sdf.parse(startdate);
            Date edate=sdf.parse(enddate);
            List<Order> orders=orderDAO.getListOrder();
            List<Order> filterlist=new ArrayList<>();
            for(Order o:orders){
                Date createat=sdf.parse(o.getCreate_at());
                if(createat.after(edate)||createat.before(sdate)){
                    filterlist.add(o);
                }
            }
            orders.removeAll(filterlist);
            for(Client c:clients){
                ClientStat clientStat=new ClientStat(c.getClient_id(),c.getAccount_id(),c.getName(),c.getAddress(),c.getPhone(),c.getGender(),c.getDob());
                int nooftransaction=0;
                float revenue=0;
                for(Order o:orders){
                    if(o.getClientid()==c.getClient_id()){
                        nooftransaction+=1;
                        revenue=revenue+o.getTotal_amount();
                    }
                }
                clientStat.setRevenue(revenue);
                clientStat.setNumberoftransaction(nooftransaction);
                clientStats.add(clientStat);
            }
            return clientStats;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Order> getClientStatDetail(int clientid, String startdate, String enddate) {
        try{
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Date edate=sdf.parse(enddate);
            Date sdate=sdf.parse(startdate);
            List<Order> orders=orderDAO.getListOrderofClient(clientid);
            List<Order> filterlist=new ArrayList<>();
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
