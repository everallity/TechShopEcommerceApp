import React from 'react'
import './dashboard.css';
import Navbar from '../../components/navbar/Navbar';
import Menu from '../../components/menu/Menu';
import Footer from '../../components/footer/Footer';
import { Outlet, useNavigate } from 'react-router-dom';
import { useLocation } from 'react-router-dom';
const Dashboard = () => {
  const location=useLocation();
  const navigate=useNavigate();
  let account=null;
  account=location.state.account;
  if(account===null){
    navigate('/')
  }
  return (
    <div>
      <div className='dashboard-main'>
        <Navbar account={account}/>
        <div className='dashboard-container'>
          <div className='dashboard-menuContainer'>
            <Menu account={account}/>
          </div>
          <div className='dashboard-contentContainer'>
            <Outlet/>
          </div>
        </div>
        <Footer/>
      </div>
    </div>
  )
}

export default Dashboard