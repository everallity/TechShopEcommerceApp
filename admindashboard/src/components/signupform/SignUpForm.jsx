import React from 'react'
import './signupform.css'
import { useNavigate } from 'react-router-dom'
import { alertClasses } from '@mui/material';
const SignUpForm = () => {
  const navigate=useNavigate();
  function signup(event){
      event.preventDefault();
     // const navigate=useNavigate();
      const data=event.target;
      const formData=new FormData(data);
      formData.append('type','1');
      const formJson = Object.fromEntries(formData.entries());
      console.log(formJson);
      const fetchbody=JSON.stringify(formJson);
      console.log(fetchbody);
      const fetchoptions ={
         
          method:"POST",
          headers: {
              "Accept": "application/json",
              // "Content-Type": "application/json",
            //   'Content-Type': 'application/x-www-form-urlencoded',
            },
          body:formData,
      };
     // 
      fetch("http://localhost:8080/account/signupstaff",fetchoptions)
      .then(res=>{
          console.log(res);
          if(res.ok){
              let data=res.json();
              return data;
          } 
      })
      .then(data=>{
          console.log(data); 
          if(data===true){
            alert("Đăng ký thành công")
          }
          return;
      })
      .catch(err=>{
          console.log(err);
          alert("Đăng ký thất bại!");
      })
  }
  function onSigninClick(event){
      event.preventDefault();
      navigate('/login')
  }
return (
  <div className='form-layout'>
      <div className='form-section-left'></div>
      <div className='form-section-right'>
          <div className='form-title'>
              <span className='title'>Đăng ký</span>
          </div>
          <div className='form-input'>
              <form onSubmit={signup} >
                  <div className='input'>
                      <label htmlFor="username">Tên đăng nhập</label>
                      <input  id='username' name='username' placeholder='Username' />
                  </div>
                  <div className='input'>
                      <label htmlFor="email">Email</label>
                      <input type="email" id='email' name='email' placeholder='Email' />
                  </div>
                  <div className='input'>
                      <label htmlFor="password">Mật khẩu</label>
                      <input type="password" id='password' name='pw' placeholder='Password'/>
                  </div>
                  <button type='submit' >Đăng ký</button>
              </form>
              <div><span>Đã có tài khoản? </span><span className='logintext' onClick={onSigninClick}>Đăng nhập</span></div>
          </div>
          
      </div>
  </div>
)
}

export default SignUpForm