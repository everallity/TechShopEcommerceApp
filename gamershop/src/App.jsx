import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import {
  createBrowserRouter,
  RouterProvider,
  Route,
  Link,
  Outlet,
  useLocation,
} from "react-router-dom";

import Navbar from './components/Navbar/Navbar';
import Footer from './components/Footer/Footer';

function App() {
  const location=useLocation();
  let account=null;
  const [client,setClient]=useState();
  console.log(account);
  account=location.state.account;
  console.log(account);
    return(
     <div className='layout_app'>
        <Navbar account={account}/> 
        <Outlet/>
        <Footer/>
     </div>
     
    )
  // const router = createBrowserRouter([
  //   {
  //     path: "/",
  //     element: <Layout/>,
  //     children: [
  //       {
  //         path:"/",
  //         element:<Cart/>
  //       },
  //       {
  //         path:"/cart",
  //         element:<Cart/>
  //       },
  //     ]
  //   },
  // ]);
  // return <RouterProvider router={router}/>
  
}

export default App
