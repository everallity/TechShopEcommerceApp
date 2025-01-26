import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import './index.css'
import { Route,BrowserRouter,Routes,RouterProvider,
  Link,
  Outlet, createBrowserRouter,createRoutesFromElements } from 'react-router-dom'
import Login from './pages/login/Login.jsx'
import Home from './pages/home/home.jsx'
import Profile from './pages/profile/Profile.jsx'
import Product from './pages/product/Product.jsx'
import Employee from './pages/employee/Employee.jsx'
import Order from './pages/order/Order.jsx'
import Review from './pages/review/Review.jsx'
import ClientStat from './pages/clientstat/ClientStat.jsx'
import ProductStat from './pages/productstat/ProductStat.jsx'
import Dashboard from './pages/dashboard/dashboard.jsx'
import ProductDetails from './pages/productdetails/ProductDetails.jsx'
import AddProduct from './pages/addproduct/AddProduct.jsx'
import AddStaff from './pages/addstaff/AddStaff.jsx'
import SignupPage from './pages/signuppage/SignUpPage.jsx'
import ProductStatDetail from './pages/productstatdetail/ProductStatDetail.jsx'
import ClientStatDetail from './pages/clientstatdetail/ClientStatDetail.jsx'
const router = createBrowserRouter([
  {
    path: "/dashboard",
   // element:<Login/>,
    element: <Dashboard/>,
    children: [
      {
        path:"",
        element:<Home/>
      },
      {
        path:"profile",
        element:<Profile/>
      },
      {
        path:"product",
        element:<Product/>,
      },
      {
        path:"productdetails",
        element:<ProductDetails/>,
      },
      {
        path:"addproduct",
        element:<AddProduct/>,
      },
      {
        path:"employee",
        element:<Employee/>
      },
      {
        path:"addstaff",
        element:<AddStaff/>
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
      {
        path:"productstatdetail",
        element:<ProductStatDetail/>
      },
      {
        path:"clientstatdetail",
        element:<ClientStatDetail/>
      }
    ],
  },
  {
    path:"/login",
    element:<Login/>
  },
  {
    path:"/signup",
    element:<SignupPage/>
  },
  {
    path:"/",
    element:<App/>
  },
]);

ReactDOM.createRoot(document.getElementById('root')).render(
  
 /* <React.StrictMode>
    <App />
  </React.StrictMode>,*/
  /*
  <React.StrictMode>
    <BrowserRouter>
      <Routes>
        <Route index element={<App/>}/>
        <Route path='login' element={<Login/>}/>
        <Route/>
      </Routes>
    </BrowserRouter>

  </React.StrictMode>,
*/
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>

)
