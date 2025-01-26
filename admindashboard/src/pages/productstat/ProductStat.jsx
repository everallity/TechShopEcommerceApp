import React from 'react'
import './productstat.css'
import { DataGrid,GridToolbar} from '@mui/x-data-grid'
import { useState } from 'react'
import { useLocation, useNavigate } from 'react-router-dom'
const ProductStat = () => {
    const location=useLocation();
    let account=null;
    account=location.state.account;
    const navigate=useNavigate();
    const[sdate,setSdate]=useState("");
    const[edate,setEdate]=useState("");
    const columns=[
        {field:'product_id',headerName:'Product_ID'},
        {field: 'name',headerName:'Tên',width: 150,editable:false},
        {field: 'brand',headerName:'Thương hiệu',width: 100,editable:false},
        {field: 'category',headerName:'Chủng loại',width: 150,editable:false},
        {field: 'numbersold',headerName:'Số lượng bán',width: 150,editable:false},
        {field: 'revenue',headerName:'Lợi nhuận (đồng)',width: 150,editable:false},
      ];
    function getRowid(row){
        return row.product_id;
    }
    function handleOnRowClick(params, 
    event)
    {
        event.preventDefault();
        console.log(params.row);
        let productname=params.row.name;
        let formData=new FormData();
        formData.append("product_id",params.row.product_id);
        formData.append('edate',edate);
        formData.append('sdate',sdate);
        console.log(Object.fromEntries(formData.entries()));
        const options={
            method:"POST",
            body:formData,
        };
        fetch('http://localhost:8080/productstat/getproductstatdetail',options)
        .then(res=>{
            let data=res.json();
            return data;
        })
        .then(data=>{
            console.log(data)
            navigate('../productstatdetail',{state:{data,productname,account},replace:true})
            
        })
        .catch(err=>{
            console.log(err);
            return;
        })
        
    }
    const [producstat,setProductStat]=useState([]);
    function onDatePick(event){
        event.preventDefault();
        let formData=new FormData(event.target);
        let formjson=Object.fromEntries(formData.entries());
        setEdate(formjson.edate);
        setSdate(formjson.sdate);
        console.log(formjson);
        const options={
            method:"POST",
            headers:{
                "Accept":"application/json"
            },
            body:formData,
        }
        fetch('http://localhost:8080/productstat/getlistproductstat',options)
        .then(res=>{
            let data=res.json();
            return data;
        })
        .then(data=>{
            console.log(data)
            setProductStat(data);
            return data;
        })
        .catch(err=>{
            console.log(err);
            return;
        })
    }
  return (
    <div className='productstat-main-content'>
        <div className='productstat-content'>
            <span className='productstat-title'>Thống kê sản phẩm</span>
        </div>
        <div className='productstat-crud-table'>
            <div className='productstat-datepicker'>
                <form onSubmit={onDatePick} className='productstat-dateform'>
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
                rows={producstat}
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

export default ProductStat