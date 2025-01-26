import { Children, useState,useEffect } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import { useNavigate,useLocation } from 'react-router-dom'
import './App.css'

import {
  createBrowserRouter,
  RouterProvider,
  Route,
  Link,
  Outlet,
} from "react-router-dom";
import Home from './pages/home/home';
import Product from './pages/product/Product';
import Navbar from './components/navbar/navbar';
import Profile from './pages/profile/profile';
import Menu from './components/menu/Menu';
import './App.css'
import Footer from './components/footer/Footer';
import Employee from './pages/employee/Employee';
import Order from './pages/order/Order';
import Review from './pages/review/Review';
import ClientStat from './pages/clientstat/ClientStat';
import ProductStat from './pages/productstat/ProductStat';
import Login from './pages/login/Login';
import WelcomeForm from './components/welcomeform/WelcomeForm'
function App() {
 // const [count, setCount] = useState(0)
 // const [user, setUser]=useState(null)
  return(
    <div className='main-layout'>
      <WelcomeForm/>
    </div>
  )
  const Layout = () => {
    //const location=useLocation();
    //const navigate=useNavigate();
    /*useEffect(()=>{
      const data=location.state;
    if(user==null){
      console.log(data);
      navigate('/login');
    }
   },[])
   if(user===undefined){
    return null;
   }*/
    return(
      <div className='main'>
        <Navbar/>
        <div className='container'>
          <div className='menuContainer'>
            <Menu/>
          </div>
          <div className='contentContainer'>
            <Outlet/>
          </div>
        </div>
        <Footer/>
      </div>
    )
  } 
 /* const router = createBrowserRouter([
    {
      path: "/dashboard",
     // element:<Login/>,
      element: <Layout/>,
      children: [
        {
          path:"home",
          element:<Home/>
        },
        {
          path:"profile",
          element:<Profile/>
        },
        {
          path:"product",
          element:<Product/>
        },
        {
          path:"employee",
          element:<Employee/>
        },
        {
          path:"order",
          element:<Order/>
        },
        {
          path:"review",
          element:<Review/>
        },
        {
          path:"clientstat",
          element:<ClientStat/>
        },
        {
          path:"productstat",
          element:<ProductStat/>
        },
      ],
    },
    {
      path:"/",
      element:<Login/>
    }
  ]);
  return <RouterProvider router={router}/> */
}

export default App
