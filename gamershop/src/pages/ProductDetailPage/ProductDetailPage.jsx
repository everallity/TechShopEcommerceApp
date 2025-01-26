import React from 'react'
import { useLocation } from 'react-router-dom';
import './productdetailpage.css'
const ProductDetailPage = () => {
    const location=useLocation();
    let account=null;
    account=location.state.account;
    let item=null;
    item=location.state.item;
    console.log(item);
    console.log(account);
    function onAddClick(event){
      event.preventDefault();
      let formData=new FormData();
      console.log(account);
      console.log(item);
      Object.keys(account).forEach(key=>{
         formData.append(key,account[key]);
       })
       formData.append("product_id",item.product_id);
      console.log(Object.fromEntries(formData.entries()));
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
  return (
    <div className='producdetail-container'>
        <div className='producdetail-shop-section'>
            <div className='producdetail-section-info'>
              <span className='producdetail-section-title'>Thông tin sản phẩm</span>
            </div>
         </div>
         <div className='productdetail-details'>
          <img src={item.image} alt="" />
          <div className='productdetail-infogroup'>
            <span>Tên sản phẩm:    <span>{item.name}</span> </span>
            
            <span>Thương hiệu: <span>{item.brand}</span></span>
            <span>Chủng loại: <span>{item.category}</span> </span>
            <span>Đơn giá: <span>{item.price}</span></span>
            <span>Tồn kho: <span>{item.stock}</span></span>
            <span>Mô tả: <span>{item.description}</span></span>
          </div>
          <button  onClick={onAddClick}>Thêm vào giỏ</button>
         </div>
    </div>
  )
}

export default ProductDetailPage