import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import './index.css'
import { createBrowserRouter,RouterProvider } from 'react-router-dom'
import Home from './pages/Home/Home.jsx'
import PhonePage from './pages/PhonePage/PhonePage.jsx'
import PCPage from './pages/PCPage/PCPage.jsx'
import ConsolePage from './pages/ConsolePage/ConsolePage.jsx'
import LaptopPage from './pages/LaptopPage/LaptopPage.jsx'
import AccessoryPage from './pages/AccessoryPage/AccessoryPage.jsx'
import SignupPage from './pages/SignupPage/SignupPage.jsx'
import LoginPage from './pages/LoginPage/LoginPage.jsx'
import Cart from './pages/Cart/Cart.jsx'
import ProductDetailPage from './pages/ProductDetailPage/ProductDetailPage.jsx'
import ProfilePage from './pages/Profile/ProfilePage.jsx'
import OrderHistoryPage from './pages/OrderHistoryPage/OrderHistoryPage.jsx'
const route=createBrowserRouter([
  {
    path:"/",
    element:<LoginPage/>
  },
  {
    path:"/signup",
    element:<SignupPage/>
  },
  {
    path:'/home',
    element:<App/>,
    children:[
      {
        path:'',
        element:<Home/>
      },
      {
        path:'phone',
        element:<PhonePage/>
      },
      {
        path:'pc',
        element:<PCPage/>
      },
      {
        path:'console',
        element:<ConsolePage/>
      },
      {
        path:'laptop',
        element:<LaptopPage/>
      },
      {
        path:'accessory',
        element:<AccessoryPage/>
      },
      {
        path:"cart",
        element:<Cart/>
      },
      {
        path:"productdetail",
        element:<ProductDetailPage/>
      },
      {
        path:"profile",
        element:<ProfilePage/>
      },
      {
        path:"orderhistory",
        element:<OrderHistoryPage/>
      },
    ],
  },
  
])
ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router={route}/>
  </React.StrictMode>
)
