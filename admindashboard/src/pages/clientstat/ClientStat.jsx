import React, { useState } from 'react'
import './clientstat.css'
import { DataGrid,GridToolbar} from '@mui/x-data-grid'
import Button from '@mui/material/Button'
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { DatePicker } from '@mui/x-date-pickers/DatePicker';
import { DemoContainer } from '@mui/x-date-pickers/internals/demo';
import { useLocation,useNavigate } from 'react-router-dom';
const ClientStat = () => {
    const location=useLocation();
    let account=null;
    account=location.state.account;
    const navigate=useNavigate();
    const[sdate,setSdate]=useState("");
    const[edate,setEdate]=useState("");
    const columns=[
        {field:'client_id',headerName:'Client_ID'},
        {field: 'account_id',headerName:'Account_ID',width: 100,editable:false},
        {field: 'name',headerName:'Tên',width: 150,editable:false},
        {field: 'address',headerName:'Địa chỉ',width: 100,editable:false},
        {field: 'dob',headerName:'Sinh nhật',width: 150,editable:false},
        {field: 'gender',headerName:'Giới tính',width: 150,editable:false},
        {field: 'phone',headerName:'Điện thoại',width: 150,editable:false},
        {field: 'numberoftransaction',headerName:'Số lần mua hàng',width: 150,editable:false},
        {field: 'revenue',headerName:'Lợi nhuận (đồng)',width: 150,editable:false},
      ];
    function getRowid(row){
        return row.client_id;
    }
    function handleOnRowClick(params, // GridRowParams
    event, // MuiEvent<React.MouseEvent<HTMLElement>>
    details,) // GridCallbackDetails )
    {
        event.preventDefault();
        console.log(params.row);
        let clientname=params.row.name;
        let formData=new FormData();
        formData.append("client_id",params.row.client_id);
        formData.append('edate',edate);
        formData.append('sdate',sdate);
        console.log(Object.fromEntries(formData.entries()));
        const options={
            method:"POST",
            body:formData,
        };
        fetch('http://localhost:8080/clientstat/getclientstatdetail',options)
        .then(res=>{
            let data=res.json();
            return data;
        })
        .then(data=>{
            console.log(data)
            navigate('../clientstatdetail',{state:{data,clientname,account},replace:true})
            
        })
        .catch(err=>{
            console.log(err);
            return;
        })
        
    }
    const [clientstat,setClientStat]=useState([]);
    function onDatePick(event){
        event.preventDefault();
        let formData=new FormData(event.target);
        let formjson=Object.fromEntries(formData.entries());
        setEdate(formjson.edate);
        setSdate(formjson.sdate);
        const options={
            method:"POST",
            headers:{
                "Accept":"application/json"
            },
            body:formData,
        }
        fetch('http://localhost:8080/clientstat/getlistclientstat',options)
        .then(res=>{
            let data=res.json();
            return data;
        })
        .then(data=>{
            console.log(data)
            setClientStat(data);
            return data;
        })
        .catch(err=>{
            console.log(err);
            return;
        })
    }
  return (
    <div className='clientstat-main-content'>
        <div className='clientstat-content'>
            <span className='clientstat-title'>Thống kê khách hàng</span>
        </div>
        <div className='clientstat-crud-table'>
            <div className='clientstat-datepicker'>
                <form onSubmit={onDatePick} className='clientstat-dateform'>
                    <label htmlFor="sdate">Ngày bắt đầu:
                    <input type="date" name="sdate" id="sdate" required />
                     </label>
                     <label htmlFor="edate">Ngày kết thúc:
                    <input type="date" name="edate" id="edate" required />
                     </label>
                     <button type='submit' >Tìm kiếm</button>
                </form>
            </div>
            <DataGrid
                className=''
                columns={columns}
                rows={clientstat}
                editMode='row'
                getRowId={getRowid}
                pageSize={10}
                slots={{toolbar:GridToolbar}}
                onRowClick={handleOnRowClick}
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

export default ClientStat