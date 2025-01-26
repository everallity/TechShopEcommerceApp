import React from 'react'
import './index.css'
import { Form ,redirect,useNavigate} from 'react-router-dom'
import { useEffect } from 'react'
const LoginForm = () => {
    const navigate=useNavigate();
    let account=null;
    function loginSuccess(data){
        account=data;
        navigate('/dashboard',{state:{account}});
    }
    function login(event){
        event.preventDefault();
       // const navigate=useNavigate();
        const formData=new FormData(event.target);
        formData.append("type",1);
        const formJson = Object.fromEntries(formData.entries());
        console.log(formJson);
        const fetchbody=JSON.stringify(formJson);
        console.log(fetchbody);
        const fetchoptions ={
           
            method:"POST",
            headers: {
                "Accept": "application/json",
             //   "Content-Type": "application/json",
              //   'Content-Type': 'application/x-www-form-urlencoded',
              },
            body:formData,
        };
       // 
        fetch("http://localhost:8080/account/login",fetchoptions)
        .then(res=>{
            console.log(res);
            if(res.ok){
                let data=res.json();
                return data;
            } 
        })
        .then(data=>{
            console.log(data); 
            console.log("Login success");
            loginSuccess(data);
        })
        .catch(err=>{
            console.log(err);
            alert("Login failed!");
        })
    }
    function onSignupClick(event){
        event.preventDefault();
        navigate('/signup')
    }
  return (
    <div className='form-layout'>
        <div className='form-section-left'></div>
        <div className='form-section-right'>
            <div className='form-title'>
                <span className='title'>Đăng nhập</span>
            </div>
            <div className='form-input'>
                <form onSubmit={login} >
                    <div className='input'>
                        <label htmlFor="email">Email</label>
                        <input type="email" id='email' name='email' placeholder='Email' required/>
                    </div>
                    <div className='input'>
                        <label htmlFor="password">Mật khẩu</label>
                        <input type="password" id='password' name='pw' placeholder='Password' required/>
                    </div>
                    <button type='submit' >Đăng nhập</button>
                </form>
                <div><span>Chưa có tài khoản? </span><span className='signuptext' onClick={onSignupClick}>Đăng ký</span></div>
            </div>
            
        </div>
    </div>
  )
}

export default LoginForm