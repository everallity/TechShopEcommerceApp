import React from 'react'
import './addproduct.css'
import { useState } from 'react'
import { useNavigate,useLocation } from 'react-router-dom';
const AddProduct = () => {
  const location=useLocation();
  let account=null;
  account=location.state.account;
    const [thumbnail,setThumbnail]=useState("");
    const navigate=useNavigate();
    function handleImgSelect(event){
        event.preventDefault();
        console.log(event.target.files[0].name);
        let img=URL.createObjectURL(event.target.files[0]);
        setThumbnail(img);
    }
    function handleOnClick(event){
        event.preventDefault();
        navigate("../product",{replace:true,state:{account}});
    }
    function handleOnSubmit(event){
        event.preventDefault();
        const formData=new FormData(event.target);
        const options={
            method:"POST",
            header:{
                "Accept": "application/json",
            },
            body:formData,
        }
        fetch("http://localhost:8080/product/addproduct",options)
        .then(res=>{
            let data=res.json();
            return data;
        })
        .then(data=>{
            console.log(data);
            if(data===true){
                alert("Thêm sản phẩm thành công")
              }
              else{
                alert("Thêm sản phẩm không thành công")
              }
            return data;
        })
        .catch(err=>{
            console.log(err);
            return;
        })
    }
  return (
    <div className='addproduct_main'>
      <div className='addproduct_title'>
        <span className='title'>Thêm sản phẩm</span>
      </div>
      <form onSubmit={handleOnSubmit}>
        <div className='addproduct_content'>
          <div className='addproduct_content_row'>
            <div className='addproduct_content_row_left'>
              <div className='addproduct_image'>
                <img src={thumbnail} alt="" />
              </div>
              <input id='file' name='file' type="file" accept='image/png,image/jpeg' onChange={handleImgSelect} />
              <label className='uploadImage' htmlFor="file">
                Đăng Ảnh
              </label>
            </div>
            <div className='addproduct_content_row_right'>
              <label htmlFor="name" >
              Tên sản phẩm:
              <input type="text" id='name' name='name'  />
              </label>
              <label htmlFor="brand">
                Thương hiệu:
              <input type="text" id='brand' name='brand' />
              </label>
              <label htmlFor="category">
                Loại sản phẩm:
              <select name="category" id="category" >
                <option value="Console">Console</option>
                <option value="Phone">Phone</option>
                <option value="PC">PC</option>
                <option value="Laptop">Laptop</option>
                <option value="Accessories">Accessories</option>
              </select>
              </label>
              <label htmlFor="price" className='labelprice'>
                Đơn giá:
              <input type="text" id='price' name='price' className='inputprice' />
              </label>
              <label htmlFor="name">
                Số lượng tồn kho:
              <input type="text" id='stock' name='stock' className='inputprice'/>
              </label>
            </div>
          </div>
          <div className='addproduct_content_row'>
            <label htmlFor="desc">
              Mô tả sản phẩm:
              <textarea name="desc" id="desc" cols="50" rows="10" ></textarea>
            </label>
              <button  className='cancelbtn' onClick={handleOnClick}>Quay lại</button>
              <button type='submit'>Thêm sản phẩm</button>
          </div>
        </div>
      </form>
    </div>
  )
}

export default AddProduct