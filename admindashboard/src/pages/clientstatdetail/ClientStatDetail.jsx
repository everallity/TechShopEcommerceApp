import React from 'react'
import './clientstatdetail.css'
import { DataGrid,GridToolbar} from '@mui/x-data-grid'
import { useState } from 'react'
import { useLocation } from 'react-router-dom'
const ClientStatDetail = () => {
    const location=useLocation();
    let account=null;
     account=location.state.account;
    
    let order=[];
    let clientname=null;
    order=location.state.data;
    clientname=location.state.clientname;

    console.log(order);
    const columns=[
        {field:'id',headerName:'Order_ID',editMode:false},
        {field: 'clientid',headerName:'Client_ID',width: 150,editable:false},
        {field: 'shipping_address',headerName:'Nơi nhận hàng',width: 100,editable:false},
        {field: 'shipping_fee',headerName:'Phí vận chuyển',width: 150,editable:false},
        {field: 'total_amount',headerName:'Tổng tiền (đồng)',width: 150,editable:false},
        {field: 'create_at',headerName:'Ngày check out',width: 150,editable:false},
      ];
    function getRowid(row){
        return row.id;
    }
  return (
    <div className='clientstatdetail-main-content'>
        <div className='clientstatdetail-content'>
            <span className='clientstatdetail-title'>Thống kê chi tiết khách hàng: {clientname}</span>
        </div>
        <div className='clientstatdetail-crud-table'>
            <DataGrid
                className=''
                columns={columns}
                rows={order}
                editMode='row'
                getRowId={getRowid}
                pageSize={10}
                slots={{toolbar:GridToolbar}}
                rowHeight={'auto'}
                disableRowSelectionOnClick
                disableColumnFilter
                disableDensitySelector
                disableColumnSelector
            />
            
        </div>
    </div>

  )
}

export default ClientStatDetail