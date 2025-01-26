import React from 'react'
import './addstaff.css'
import { useState } from 'react'
import { useNavigate } from 'react-router-dom';
const AddStaff = () => {
    const navigate=useNavigate();
    function handleOnSubmit(){

    }
    function handleOnClick(){

    }
  return (
    <div className='addstaff_main'>
      <div className='addstaff_title'>
        <span className='title'>Thêm sản phẩm</span>
      </div>
      <form onSubmit={handleOnSubmit}>
        <div className='addstaff_content'>
          <div className='addstaff_content_row'>
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
          <div className='addstaff_content_row'>
            <label htmlFor="desc">
              Mô tả sản phẩm:
              <textarea name="desc" id="desc" cols="50" rows="10" ></textarea>
            </label>
              <button  className='cancelbtn' onClick={handleOnClick}>Quay lại</button>
              <button type='submit'>Thêm sản phẩm</button>
          </div>
      </form>
    </div>
  )
}

export default AddStaff