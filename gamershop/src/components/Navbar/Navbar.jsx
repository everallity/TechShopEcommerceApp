import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import './navbar.css'
const Navbar = (props) => {
  const navigate=useNavigate();
  let account=props.account;
  function handleOnLoginClick(event){
    navigate('/login');
  }
  function handleOnSignoutClick(event){
    account=undefined;
    navigate('/',{state:account});
  }
  if(account===null){
    return (
      <div className='navbar'>
          <div className='logo'>
            <img/>
            <span>TECH SHOP</span>
          </div>
          <div className='links'>
          <ul className='list-links'>
              <li><Link to={''} state={{account:account}} className='nav-link'>Trang chủ</Link></li>
              <li><Link to={'cart'} state={{account:account}} className='nav-link'>Giỏ hàng</Link></li>
              <li><Link to={'profile'} state={{account:account}} className='nav-link'>Thông tin cá nhân</Link></li>
              <li><Link to={'orderhistory'} state={{account:account}} className='nav-link'>Lịch sử mua hàng</Link></li>
            </ul>
            <ul className='list-links'>
              <li><Link to={'phone'} state={{account:account}} className='nav-link'>Điện thoại</Link></li>
              <li><Link to={'console'} state={{account:account}} className='nav-link'>Máy chơi game</Link></li>
              <li><Link to={'pc'} state={{account:account}} className='nav-link'>Máy tính bàn</Link></li>
              <li><Link to={'accessory'} state={{account:account}} className='nav-link'>Phụ kiện</Link></li>
              <li><Link to={'laptop'} state={{account:account}} className='nav-link'>Máy tính xách tay</Link></li>
            </ul>
          </div>
          <div className='user'>
            <span className='clickable_text' onClick={handleOnLoginClick}>Đăng nhập</span>
          </div>
      </div>
    )
  }
  return (
    <div className='navbar'>
        <div className='logo'>
          <img/>
          <span>TECH SHOP</span>
        </div>
        <div className='links'>
        <ul className='list-links'>
              <li><Link to={''} state={{account:account}} className='nav-link'>Trang chủ</Link></li>
              <li><Link to={'cart'} state={{account:account}} className='nav-link'>Giỏ hàng</Link></li>
              <li><Link to={'profile'} state={{account:account}} className='nav-link'>Thông tin cá nhân</Link></li>
              <li><Link to={'orderhistory'} state={{account:account}} className='nav-link'>Lịch sử mua hàng</Link></li>
            </ul>
            <ul className='list-links'>
              <li><Link to={'phone'} state={{account:account}} className='nav-link'>Điện thoại</Link></li>
              <li><Link to={'console'} state={{account:account}} className='nav-link'>Máy chơi game</Link></li>
              <li><Link to={'pc'} state={{account:account}} className='nav-link'>Máy tính bàn</Link></li>
              <li><Link to={'accessory'} state={{account:account}} className='nav-link'>Phụ kiện</Link></li>
              <li><Link to={'laptop'} state={{account:account}} className='nav-link'>Máy tính xách tay</Link></li>
            </ul>
        </div>
        <div className='user'>
          <span>Xin chào khách hàng: </span><span>{account.username}</span>
          <span className='clickable_text' onClick={handleOnSignoutClick}>Đăng xuất</span>
        </div>
    </div>
  )
}

export default Navbar