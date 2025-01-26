import React from 'react'
import Navbar from '../../components/Navbar/Navbar'
import Footer from '../../components/Footer/Footer'
import ProductList from '../../components/ProductList/ProductList'
import './home.css'
import ShoppingCart from '../../components/ShoppingCart/ShoppingCart'
import { useState,useEffect } from 'react'
import { useNavigate ,useLocation } from 'react-router-dom'
const Home = () => {
  const [productlist,setProductlist]=useState();
  const location=useLocation();
  let account=null;
  account=location.state.account;
  useEffect(()=>{
    fetch('http://localhost:8080/product/getlistproduct')
    .then(res=>{
      let data=res.json();
      return data;
    })
    .then(data=>{
      setProductlist(data);
    })
    .catch(err=>{
      console.log(err);
      return;
    })
  },[]);
  console.log(productlist);
  if(productlist===undefined){
    return(
      <div className='temp'>Fetching data...</div>
    )           
  }
  return (
        <div className='home-container'>
          <div className='shop-section'>
            <div className='section-info'>
              <span className='section-title'>Danh sách tất cả sản phẩm</span>
            </div>
            <div className='section-products'>
             <ProductList list={productlist} account={account}/>  
            </div>
          </div>            
        </div>
    
  )
}

export default Home