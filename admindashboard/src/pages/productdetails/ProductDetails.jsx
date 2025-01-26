import React from 'react'
import './productdetails.css'
import { useParams,useNavigate,useLocation, Form } from 'react-router-dom'
import { useEffect,useState } from 'react'
const ProductDetails = () => {
  const navigate=useNavigate();
  const location=useLocation();
  let account=null;
  account=location.state.account;
  let productdata=location.state.editRow;
  let newdata=productdata;
  // console.log(productdata);
  const [thumbnail,setThumbnail]=useState(productdata.image);
  function onSubmitListener(event){
    event.preventDefault();
  }
  function handleOnSubmit(event){
    event.preventDefault();
    const formData=new FormData(event.target);
    formData.append("productid",productdata.product_id);
    formData.append("image",productdata.image);
    const formJson=Object.fromEntries(formData.entries());
    console.log(formJson);
    const options={
      method:"POST",
      headers:{

        "Accept": "application/json",

      },
      body:formData,
    }
    fetch("http://localhost:8080/product/editproduct",options)
    .then(res=>{
      let data=res.json();
      return data;
    })
    .then(data=>{
      console.log(data);
      if(data===true){
        alert("Cập nhật sản phẩm thành công")
      }
      else{
        alert("Cập nhật sản phẩm không thành công")
      }
      return data;
    })
    .catch(err=>{
      console.log(err);
      alert("Cập nhật sản phẩm không thành công")
      return;
    })
    
  }
  function handleOnClick(event){
    event.preventDefault();
    navigate("../product",{replace:true,state:{account}});
  }
  function handleImgSelect(event){
    event.preventDefault();
    console.log(event.target.files[0].name);
    const img=URL.createObjectURL(event.target.files[0]);
    console.log(img);
    setThumbnail(img);
    newdata.image=event.target.files[0].name;
    console.log(newdata);
    console.log(productdata.image);
  }
  return  (
    <div className='productdetails_main'>
      <div className='page_title'>
        <span className='title'>Thông tin sản phẩm</span>
      </div>
      <form onSubmit={handleOnSubmit}>
        <div className='productdetails_content'>
          <div className='productdetails_content_row'>
            <div className='productdetails_content_row_left'>
              <div className='productdetails_image'>
                <img src={thumbnail} alt="thumbnail" />
              </div>
              <input id='file' name='file' type="file" accept='image/png,image/jpeg' onChange={handleImgSelect} />
              <label className='uploadImage' htmlFor="file">
                Đăng Ảnh
              </label>
            </div>
            <div className='productdetails_content_row_right'>
              <label htmlFor="name" >
              Tên sản phẩm:
              <input type="text" id='name' name='name' defaultValue={productdata.name} />
              </label>
              <label htmlFor="brand">
                Thương hiệu:
              <input type="text" id='brand' name='brand' defaultValue={productdata.brand}/>
              </label>
              <label htmlFor="category">
                Loại sản phẩm:
              <select name="category" id="category" defaultValue={productdata.category}>
                <option value="Console">Console</option>
                <option value="Phone">Phone</option>
                <option value="PC">PC</option>
                <option value="Laptop">Laptop</option>
                <option value="Accessories">Accessories</option>
              </select>
              </label>
              <label htmlFor="price" className='labelprice'>
                Đơn giá:
              <input type="text" id='price' name='price' className='inputprice' defaultValue={productdata.price}/>
              </label>
              <label htmlFor="name">
                Số lượng tồn kho:
              <input type="text" id='stock' name='stock' className='inputprice' defaultValue={productdata.stock} />
              </label>
            </div>
          </div>
          <div className='productdetails_content_row'>
            <label htmlFor="desc">
              Mô tả sản phẩm:
              <textarea name="desc" id="desc" cols="50" rows="10" defaultValue={productdata.description}></textarea>
            </label>
              <button  className='cancelbtn' onClick={handleOnClick}>Quay lại</button>
              <button type='submit'>Lưu cập nhật</button>
          </div>
        </div>
      </form>
    </div>
  )
}

export default ProductDetails