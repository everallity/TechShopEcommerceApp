import React, { useEffect, useState } from 'react'
import './profilepage.css'
import { useLocation } from 'react-router-dom';
const ProfilePage = () => {
    const location=useLocation();
    let account=null;
    account=location.state.account;
    const [client,setClient]=useState([]);
    function loadData(){
      let formData=new FormData();
      formData.append("email",account.email);
      formData.append("id",account.id);
      formData.append("password",account.password);
      formData.append("username",account.username);
      formData.append("type",account.type);
      const options={
        method:"POST",
        body:formData
      }
      fetch('http://localhost:8080/client/getclientbyaccount',options)
      .then(res=>{
        let data=res.json();
        return data;
      })
      .then(data=>{
        console.log(data);
        setClient(data);
      })
      .catch(err=>{
        console.log(err);
        return;
      })
    }
    
    function handleSubmit(event){
      event.preventDefault();
      let formData= new FormData(event.target);
      formData.append("id",client.client_id);
      console.log(Object.fromEntries(formData.entries()));
      const options={
        method:"POST",
        body:formData
      }
      fetch('http://localhost:8080/client/editclient',options)
      .then(res=>{
        let data=res.json();
        return data;
      })
      .then(data=>{
        if(data===true){
          alert("Cập nhật thành công");
        }else{
          alert("Cập nhật thất bại");
        }
        loadData();
        return data;
      })
      .catch(err=>{
        console.log(err);
        return;
      })
    }
     useEffect(()=>{
      loadData();
      console.log(client);
    },[])
    
  return (
    <div className='profile-container'>
        <div className='shop-section'>
            <div className='section-info'>
              <span className='section-title'>Thông tin cá nhân</span>
            </div>
        </div>
      <div className='profile-main-content'>
        <form onSubmit={handleSubmit}>
          <div className='profile-form'>
          <label htmlFor="name">
          Tên:
          <input type="text" id='name' name='name' defaultValue={client.name}/>
          </label>
          <label htmlFor="address">
          Địa chỉ:
          <input type="text" id='address' name='address' defaultValue={client.address}/>
          </label>
          <label htmlFor="dob">
          Ngày sinh:
          <input type="text" id='dob' name='dob' defaultValue={client.dob}/>
          </label>
          <label htmlFor="phone">
          Điện thoại:
          <input type="text" id='phone' name='phone' defaultValue={client.phone}/>
          </label>
          <label htmlFor="gender">
          Giới tính:
          <input type="text" id='gender' name='gender' defaultValue={client.gender}/>
          </label>
          <label htmlFor="gender">
          </label>
          <button type='submit'>Save</button>
          </div>
        </form>
      </div>
    </div>
  )
}

export default ProfilePage