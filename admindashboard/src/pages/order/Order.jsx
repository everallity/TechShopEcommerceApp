import React from 'react'
import { DataGrid,GridToolbar,GridRowModes,GridActionsCellItem} from '@mui/x-data-grid'
import Button from '@mui/material/Button'
import AddIcon from '@mui/icons-material/Add';
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/DeleteOutlined';
import SaveIcon from '@mui/icons-material/Save';
import CancelIcon from '@mui/icons-material/Close';
import { Box } from '@mui/material';
import './order.css'
import { useEffect,useState } from 'react';
import { renderTimeViewClock } from '@mui/x-date-pickers';
import ProductDetails from '../productdetails/ProductDetails';
import { useGridApiRef,useGridApiContext } from '@mui/x-data-grid';
import { useNavigate } from 'react-router-dom';
const Order = () => {
  function getRowId(row){
    return row.id;
  }
const [orderlist,setorderlist]=useState({});
const navigate=useNavigate();
function loadData(){
  const options={
    method:"GET",
  };
  fetch('http://localhost:8080/order/getlistorder',options)
  .then(res=>{
    let data=res.json();
    return data;
  })
  .then(data=>{
    setorderlist(data);
  })
  .catch(err=>{
    console.log(err);
    return;
  })
}
useEffect(()=>{
  loadData();
},[])
function onDeleteClickListener(id){
  console.log(id);
    const deletedRow=orderlist.find((row)=>
      row.id===id
    )
    console.log(deletedRow);
    deleteData(deletedRow);
}
function deleteData(deletedData){
  console.log("data is"+ JSON.stringify(deletedData) );
  const fetchOptions={
    method:"POST",
    headers: {
              "Content-Type": "application/json",
            //   'Content-Type': 'application/x-www-form-urlencoded',
            },
          body:JSON.stringify(deletedData),
  };
  fetch("http://localhost:8080/order/deleteorder",fetchOptions)
  .then(res=>{
    console.log(res);
    if(res.ok){
      let data=res.text();
      return data;
    }
  })
  .then(data=>{
    console.log(data);
    loadData();
    return data;
  })
  .catch(err=>{
    console.log(err);
  })
  
}
function onEditClickListener(id){

}
function handleEditstop(updatedRow){
  console.log(updatedRow);
   let formData=new FormData();
  formData.append("clientid",updatedRow.clientid);
   formData.append("create_at",updatedRow.create_at);
   formData.append("id",updatedRow.id);
  formData.append("order_status",updatedRow.order_status);
   formData.append("shipping_address",updatedRow.shipping_address);
  formData.append("shipping_fee",updatedRow.shipping_fee);
   formData.append("total_amount",updatedRow.total_amount);
  const options={
    method:"POST",
    body:formData
  }
  fetch('http://localhost:8080/order/editorder',options)
  .then(res=>{
    console.log(res);
    if(res.ok){
      let data=res.json();
      return data;
    }
  })
  .then(data=>{
    console.log(data);
    loadData();
    return data;
  })
  .catch(err=>{
    console.log(err);
  })
}
function handleError(){

}
const columns=[
  {field:'id',headerName:'Order_ID',editable:false,type:'number'},
  {field: 'shipping_address',headerName:'Nơi nhận',width: 150,editable:false},
  {field: 'shipping_fee',headerName:'Phí chuyển phát',width: 150,editable:false},
  {field: 'order_status',headerName:'Trạng thái',width: 150,editable:true,type:'singleSelect',valueOptions:['Pending','Shipping','Arrived','Canceled']},
  {field: 'total_amount',headerName:'Tổng tiền',width: 150,type:'number',editable:false},
  {field: 'create_at',headerName:'Ngày đặt',width: 150,editable:false},
  {field: 'clientid',headerName:'Client_ID',width: 100,editable:true},
  { 
    field:'actions',
    type:'actions',
    headerName:'Actions',
    width:100,
    getActions:({id})=>{
        return [
          <GridActionsCellItem
            icon={<EditIcon/>}
            onClick={onEditClickListener.bind(this,id)}
            label='Edit'
          />,
          <GridActionsCellItem
            icon={<DeleteIcon/>}
            onClick={onDeleteClickListener.bind(this,id)}
            label='Delete'
          />,
        ];
      },
    },
];
  return (
    <div className='main-content'>
      <div className='content'>
        <span className='title'>Danh sách đơn hàng</span>
      </div>
        <Box sx={{
          width:'100%',
        }
        }>
        <DataGrid 
          className=''
          getRowId={getRowId}
          columns={columns}
          rows={orderlist}
          getRowHeight={() => 'auto'}
          editMode='row'
          pageSize={10}
          slots={{toolbar:GridToolbar}}
          disableRowSelectionOnClick
          disableColumnFilter
          disableDensitySelector
          processRowUpdate={(updatedRow,originalRow)=>handleEditstop(updatedRow)}
          onProcessRowUpdateError={handleError}
        />
        </Box>
    </div>
    


  )
}

export default Order