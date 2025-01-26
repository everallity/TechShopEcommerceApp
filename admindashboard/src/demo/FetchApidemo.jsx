import React from 'react'
import { useState,useEffect } from 'react';

function FetchApidemo() {
  const [userList,setUserList]=useState({})
  useEffect(()=>{
    fetch("https://jsonplaceholder.typicode.com/users")
      .then(res=>{
        console.log(res);
        return res.json();
      })
      .then(data=>{
        setUserList(data)
      })
       
  },[])
  console.log(userList)
  return (
    <div>
      {userList.map(user=>(
        <div key={i}>
          <span>{user.name}</span>
          <span>{user.email}</span>
        </div>
      ))}
    </div>
  );
}

export default FetchApidemo