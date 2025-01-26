import React from 'react'
import './index.css'
import { useLocation, useNavigate } from 'react-router-dom';
const Navbar = () => {
 // let account=props.account;
 let account=null;
 const location=useLocation();
 account=location.state.account;
  console.log('navbar'+account.username);
  const navigate=useNavigate();
  function onSignoutClick(){
    navigate('/');
  }
  return (
    <div className='navbar'>
      <div className='logo'>
        Dashboard
      </div>
      <div className='nav-icons'>
        <div className='user'>
          <span>Chào mừng: </span>
          <span> {account.username} </span>
        </div>
      </div>
      <span onClick={onSignoutClick} className='signouttext'>Đăng xuất</span>
    </div>
  )
}

export default Navbar