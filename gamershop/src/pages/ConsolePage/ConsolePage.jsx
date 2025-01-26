import React from 'react'
import './consolepage.css'
import { useEffect, useState } from 'react'
import Navbar from '../../components/Navbar/Navbar'
import ProductList from '../../components/ProductList/ProductList'
import { useLocation } from 'react-router-dom'
const ConsolePage = () => {
    const [productlist,setProductlist]=useState();
    const location=useLocation();
     let account=null;
    account=location.state.account;
    useEffect(()=>{
        const formData=new FormData();
        formData.append('category','Console');
        const options={
            method:"POST",
            headers:{
                'Accept': 'application/json',
            },
            body:formData
        };
        fetch('http://localhost:8080/product/getproductbycategory',options)
        .then(res=>{
            let data=res.json();
            return data;
        })
        .then(data=>{
            console.log(data);
            setProductlist(data);
            return;
        })
        .catch(err=>{
            console.log(err);
            return;
        })
    },[]);
    if(productlist===undefined){
        return(
            <div className='temp'>Fetching data...</div>
        )
    }
  return (
    <div className='pc-container'>
        <div className='shop-section'>
            <div className='section-info'>
              <span className='section-title'>Danh sách máy chơi game</span>
            </div>
            <div className='section-products'>
             <ProductList list={productlist} account={account}/>  
            </div>
        </div>
    </div>
  )
}

export default ConsolePage