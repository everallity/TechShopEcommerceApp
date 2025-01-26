import React, { useEffect, useState } from 'react'
import './productlist.css'
import { useNavigate } from 'react-router-dom';
import { daDK } from '@mui/x-data-grid';
const ProductList = (props) => {
    const navigate=useNavigate();
    let list=props.list;
    console.log(list);
    let account=props.account;
    function handleOnAddClick(item){
        if(account===null){
            navigate("/login");
        }else{
            let formData=new FormData();
            Object.keys(account).forEach(key=>{
            formData.append(key,account[key]);
        })
        formData.append("product_id",item.product_id);
        const options={
            method:"POST",
            headers:{
                "Accept":"application/json"
            },
            body:formData
        }
        fetch('http://localhost:8080/cart/additemtocart',options)
        .then(res=>{
            let data=res.json();
            return data;
        })
        .then(data=>{
            console.log(data);
            if(data===true){
                alert("Đã thêm vào giỏ hàng");
            }
            else{
                alert("Sản phẩm đã có trong giỏ hàng");
            }
            return data;
        })
        .catch(err=>{
            console.log(err);
            return;
        })
        }
        
    }
    function handleOnDetailsClick(item){
        console.log(account);
         navigate('productdetail',{state:{
            account:account,item:item
         },replace:true});
    }
  return (
    <div className='gridlist'>
        {list.map(item => (
            <div className='item-card' key={item.product_id}>
                <img src={item.image} />
                <div className='card-info'>
                    <h3>{item.name}</h3>
                    <h3>{item.price} đồng</h3>
                </div>
                <div className='card-bottom'>
                    <button onClick={()=>handleOnDetailsClick(item)}>Chi tiết</button>
                    <button onClick={()=>handleOnAddClick(item)}>Thêm vào giỏ</button>
                </div>
            </div>
        ))}
    </div>
  )
}

export default ProductList