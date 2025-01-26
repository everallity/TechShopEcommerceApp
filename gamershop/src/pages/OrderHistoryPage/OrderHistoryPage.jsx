import React, { useEffect, useState } from 'react'
import './orderhistorypage.css'
import { useLocation } from 'react-router-dom';
const OrderHistoryPage = () => {
    const location=useLocation();
    let account=null;
    account=location.state.account;
    console.log(account);
    const [orderlist,setOrderlist]=useState([]);
    function loadData(){
      let formData=new FormData();
      Object.keys(account).forEach(key=>{
        formData.append(key,account[key]);
      })
      const options={
        method:"POST",
        headers:{
          "Accept":"application/json",
        },
        body:formData,
      }
      fetch('http://localhost:8080/order/getlistorderofclient',options)
      .then(res=>{
        let data=res.json();
        return data;
      })
      .then(data=>{
        console.log(data);
        setOrderlist(data)
        return;
      })
      .catch(err=>{
        console.log(err);
        return;
      })
    }
    useEffect(()=>{
      loadData();
      console.log(orderlist);
    },[])
  return (
    <div className='history-container'>
        <div className='history-shop-section'>
            <div className='history-section-info'>
              <span className='history-section-title'>Lịch sử đơn hàng của khách</span>
            </div>
        </div>
        <div className='list-section'>
        <table>
              <thead>
              <tr>
                <th>Mã khách hàng</th>
                <th>Nơi nhận</th>
                <th>Trạng thái đơn</th>
                <th>Phí vận chuyển (đồng)</th>
                <th>Tổng tiền (đồng)</th>
                <th>Đặt ngày</th>
              </tr>
              </thead>
              <tbody>
                {orderlist.map((order)=>(
                  <tr key={order.id}>
                    <td>
                        <span>{order.clientid}</span>
                    </td>
                    <td>
                      <span>{order.shipping_address} </span>
                    </td>
                    <td>
                      <span>{order.order_status} </span>
                    </td>
                    
                    <td>
                      <span>{order.shipping_fee} </span>
                    </td>
                    <td>
                    <span>{order.total_amount}</span>
                    </td>
                    <td>
                      <span>{order.create_at} </span>
                    </td>
                  </tr>
                ))}
                </tbody> 
            </table>
        </div>
    </div>
  )
}

export default OrderHistoryPage