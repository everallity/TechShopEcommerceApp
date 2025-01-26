import React from 'react'
import { Link, useLocation } from 'react-router-dom'
import './index.css'
const Menu = () => {
  let account=null;
  const location=useLocation();
  account=location.state.account;
  console.log("menu"+account.username);
  return (
    <div className='menu'>
      <div className='menuCategory'>
        <span className='categorytitle'>Tổng quan</span>
         <div className='menuFunction'>
          <Link to={""} state={{account:account}} className=''>
            <img src='' alt=''/>
            <span className='menuFunctiontitle'>Trang chủ</span>
          </Link>
        </div>
        <div className='menuFunction'>
          <Link to={"profile"} state={{account:account}} className=''>
            <img src='' alt=''/>
            <span className='menuFunctiontitle'>Thông tin cá nhân</span>
          </Link>
        </div>
      </div>
      <div className='menuCategory'>
        <span className='categorytitle'>Các danh sách</span>
        {/* <div className='menuFunction'>
          <Link to={"employee"} className=''>
            <img src='' alt=''/>
            <span className='menuFunctiontitle'>Employees</span>
          </Link>
        </div> */}
        <div className='menuFunction'>
          <Link to={"product"} state={{account:account}} className=''>
            <img src='' alt=''/>
            <span className='menuFunctiontitle'>Danh sách sản phẩm</span>
          </Link>
        </div>
        <div className='menuFunction'>
          <Link to={"order"} state={{account:account}} className=''>
            <img src='' alt=''/>
            <span className='menuFunctiontitle'>Danh sách đơn hàng</span>
          </Link>
        </div>

        {/* <div className='menuFunction'>
          <Link to={""} className=''>
            <img src='' alt=''/>
            <span className='menuFunctiontitle'>Clients</span>
          </Link>
        </div> */}
        {/* <div className='menuFunction'>
          <Link to={"review"} className=''>
            <img src='' alt=''/>
            <span className='menuFunctiontitle'>Danh sách đánh giá</span>
          </Link>
        </div> */}
      </div>
      <div className='menuCategory'>
        <span className='categorytitle'>Thống kê</span>
        <div className='menuFunction'>
          <Link to={"clientstat"} state={{account:account}} className=''>
            <img src='' alt=''/>
            <span className='menuFunctiontitle'>Thống kê khách hàng</span>
          </Link>
        </div>
        <div className='menuFunction'>
          <Link to={"productstat"} state={{account:account}} className=''>
            <img src='' alt=''/>
            <span className='menuFunctiontitle'>Thống kê sản phẩm</span>
          </Link>
        </div>
      </div>
    </div>
  )
}

export default Menu