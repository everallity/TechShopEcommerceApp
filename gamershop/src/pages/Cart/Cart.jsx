import React, { useEffect, useState } from 'react'
import Navbar from '../../components/Navbar/Navbar'
import ShoppingCart from '../../components/ShoppingCart/ShoppingCart'
import './cart.css'
import { useLocation, useNavigate } from 'react-router-dom'
const Cart = () => {
  const location=useLocation();
  const navigate=useNavigate();
  let account=null;
  account=location.state.account;
  
  const [cartitemlist,setCartItemList]=useState();
  const [cart,setCart]=useState();
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
    fetch('http://localhost:8080/cart/getcartofclient',options)
    .then(res=>{
      let data=res.json();
      return data;
    })
    .then(data=>{
      console.log(data);
      setCart(data);
      setCartItemList(data.cartItemList);
      return;
    })
    .catch(err=>{
      console.log(err);
      return;
    })
  }
  useEffect(()=>{
    
    if(account===null){
      navigate('login');
    }else{
      loadData();    
  }
    
  },[]);
  if(cartitemlist===undefined){
    return (
      <div className='temp_container'>Fetching data...</div>
    )
  }
  
  function onDeleteCartItem(cartItem){
    let formData=new FormData();
    formData.append("id",cartItem.id);
    formData.append("cart_id",cartItem.cart_id);
    formData.append("quantity",cartItem.quantity);
    formData.append("totalamount",cartItem.totalamount);
    formData.append("product_id",cartItem.product.product_id);
    const options={
      method:"POST",
      headers:{
        "Accept":"application/json",
      },
      body:formData
    };
    fetch('http://localhost:8080/cart/deletecartitem',options)
    .then(res=>{
      let data=res.json();
      return data;
    })
    .then(data=>{
      if(data===true){
        loadData();
      }
    })
  }
  function onIncreaseClick(cartItem){
    let formData=new FormData();
    formData.append("id",cartItem.id);
    formData.append("cart_id",cartItem.cart_id);
    formData.append("quantity",cartItem.quantity);
    formData.append("totalamount",cartItem.totalamount);
    formData.append("product_id",cartItem.product.product_id);
    const options={
      method:"POST",
      headers:{
        "Accept":"application/json",
      },
      body:formData
    };
    fetch('http://localhost:8080/cart/increasecartitem',options)
    .then(res=>{
      let data=res.json();
      return data;
    })
    .then(data=>{
      if(data===true){
        loadData();
      }
    })
  }
  function onDecreaseClick(cartItem){
    let formData=new FormData();
    formData.append("id",cartItem.id);
    formData.append("cart_id",cartItem.cart_id);
    formData.append("quantity",cartItem.quantity);
    formData.append("totalamount",cartItem.totalamount);
    formData.append("product_id",cartItem.product.product_id);
    const options={
      method:"POST",
      headers:{
        "Accept":"application/json",
      },
      body:formData
    };
    fetch('http://localhost:8080/cart/decreasecartitem',options)
    .then(res=>{
      let data=res.json();
      return data;
    })
    .then(data=>{
      if(data===true){
        loadData();
      }
    })
  }
  function onBuyClick(event){
    event.preventDefault();
    console.log(cart);
    let formData=new FormData(event.target);
    formData.append("id",cart.id);
    formData.append("clientid",cart.clientid);
    formData.append("final_amount",cart.final_amount);
    const options={
      method:"POST",
      headers:{
        "Accept":"application/json",
      },
      body:formData
    };
    fetch('http://localhost:8080/order/addorder',options)
    .then(res=>{
      let data=res.json();
      return data;
    })
    .then(data=>{
      if(data===true){
        alert("Mua hàng thành công")
        loadData();
      }
    })
  }
  return (
    <div className='layout-cart'>
        <div className='cart-container'>
          <div className='section-info'>
            <span className='section-title'>Giỏ hàng</span>
          </div>
          <div className='section-products'>
            <table>
              <thead>
              <tr>
                <th className='main_cell'>Sản phẩm</th>
                <th>Đơn giá</th>
                <th>Số lượng</th>
                <th>Số tiền</th>
                <th>Thao tác</th>
              </tr>
              </thead>
              <tbody>
                {cartitemlist.map((cartitem)=>(
                  <tr key={cartitem.id}>
                    <td className='main_cell'>
                        <img className='cartimage' src={cartitem.product.image} alt="" />
                        <p>{cartitem.product.name}</p>
                    </td>
                    <td>
                      <span>{cartitem.product.price} đồng</span>
                    </td>
                    <td>
                      <button onClick={()=>onDecreaseClick(cartitem)}>-</button>
                      <span>{cartitem.quantity}</span>
                      <button onClick={()=>onIncreaseClick(cartitem)}>+</button>
                    </td>
                    <td>
                      <span>{cartitem.totalamount} đồng</span>
                    </td>
                    <td>
                    <span className='deletebtn' onClick={()=>onDeleteCartItem(cartitem)}>Xóa</span>
                    </td>
                  </tr>
                ))}
                </tbody> 
            </table>
          </div>
          <div className='section_checkout'>
            <span className='checkout-title'>TỔNG KẾT ĐƠN HÀNG</span>
            <form onSubmit={onBuyClick}>
            <div className='checkout-info'>
              
              <div className='shipping_info'>
               <label htmlFor="address">
                Địa chỉ nhận hàng:
                <input type="text" name='address' id='address' required />
               </label>
              </div>
              <div className='price_info'>
               <span>Tổng giá trị giỏ hàng:</span>
               <span>{cart.final_amount} đồng</span>
              </div>
              <button type='submit'>Mua hàng</button>
              
            </div>
            </form>
          </div>
        </div>
        
    </div>
  )
}

export default Cart