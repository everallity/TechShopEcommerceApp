import React, { useEffect, useState } from 'react'
import './profile.css'
import { useLocation } from 'react-router-dom';
const Profile = () => {
  const location=useLocation();
  let account=null;
  account=location.state.account;
  const [profile,setProfile]=useState([]);
  function loadData(){
    console.log(account);
    let formData=new FormData();
    formData.append('username',account.username);
    formData.append('email',account.email);
    formData.append('password',account.password);
    formData.append('id',account.id);
    formData.append('type',account.type);
    const options={
      method:"POST",
      body:formData
    }
    fetch('http://localhost:8080/staff/getstaffinfo',options)
    .then(res=>{
      let data=res.json();
      return data;
    })
    .then(data=>{
      setProfile(data);
      return data;
    })
    .catch(err=>{
      console.log(err)
      return;
    })
  }
  useEffect(()=>{
    loadData();
    console.log(profile)
  },[])
  function handleSubmit(event){
    event.preventDefault();
    let formData=new FormData(event.target);
    console.log(Object.fromEntries(formData.entries()));
    formData.append("staff_id",profile.staff_id);
    const options={
      method:"POST",
      body:formData
    }
    fetch('http://localhost:8080/staff/editstaff',options)
    .then(res=>{
      let data=res.json();
      return data;
    })
    .then(data=>{
      if(data===true)
      {
        alert("Cập nhật thành công");
      }else{
        alert("Cập nhật thất bại");
      }
      loadData();
      return data;
    })
    .catch(err=>{
      console.log(err)
      return;
    })
  }

  return (
    <div className='profile-main-content'>
      <div className='profile-content'>
        <span className='profile-title'>Thông tin cá nhân</span>
      </div>
      <form onSubmit={handleSubmit}>
        <div className='profile-form'>
        <label htmlFor="name">
          Tên:
          <input type="text" id='name' name='name' defaultValue={profile.name}/>
        </label>
        <label htmlFor="address">
          Địa chỉ:
          <input type="text" id='address' name='address' defaultValue={profile.address}/>
        </label>
        <label htmlFor="dob">
          Ngày sinh:
          <input type="text" id='dob' name='dob' defaultValue={profile.dob}/>
        </label>
        <label htmlFor="phone">
          Điện thoại:
          <input type="text" id='phone' name='phone' defaultValue={profile.phone}/>
        </label>
        <label htmlFor="gender">
          Giới tính:
          <select name="gender" id="gender" defaultValue={profile.gender} >
                <option value="Nam">Nam</option>
                <option value="Nữ">Nữ</option>
                <option value="Khác">Khác</option>
          </select>
        </label>
        <button type='submit'>Save</button>
        </div>
      </form>
    </div>
  )
}

export default Profile