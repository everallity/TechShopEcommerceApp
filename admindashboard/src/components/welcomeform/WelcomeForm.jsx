import React from 'react'
import './index.css'
import { useNavigate } from 'react-router-dom'
const WelcomeForm = () => {
    const navigate=useNavigate();
    let account=null;
    function signinClickListener(){
        navigate('/login');
    }
    function signupClickListener(){
        navigate('/signup');
    }
  return (
    <div className='form-layout'>
    <div className='form-section-left'></div>
    <div className='form-section-right'>
        <div className='form-title'>
            <span className='title'>Welcome to TechShop Admin DashBoard</span>
        </div>
        <div className='form-input'>
            <button onClick={signinClickListener}>Sign in</button>
            <button onClick={signupClickListener}>Sign up</button>
        </div>
    </div>
</div>
  )
}

export default WelcomeForm