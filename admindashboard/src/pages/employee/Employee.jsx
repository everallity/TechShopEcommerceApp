import React from 'react'
import Button from '@mui/material/Button'
import AddIcon from '@mui/icons-material/Add';
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/DeleteOutlined';
import SaveIcon from '@mui/icons-material/Save';
import CancelIcon from '@mui/icons-material/Close';
import { useState,useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { useGridApiRef,useGridApiContext } from '@mui/x-data-grid';
import { DataGrid,GridToolbar,GridRowModes,GridActionsCellItem} from '@mui/x-data-grid'
import './index.css'

const Employee = () => {
  const [rowModesModel,setRowModesModel]=useState({});
  const [stafflist,setStafflist]=useState({});
  const navigate=useNavigate();
  const apiRef=useGridApiRef();
  function getRowId(row){
    return row.staff_id;
  }
  function loadData(){
    fetch("http://localhost:8080/account/staff/getliststaff")
      .then(res=>{
        console.log(res)
        if(res.ok){
          let data=res.json();
          return data;
        }
      })
      .then(data=>{
        console.log(data);
        setStafflist(data);
        return data;
      })
      .catch(err=>{
        console.log(err);
      })
  }
  useEffect(()=>{
    loadData();
  },[]);
  const columns=[
    {field:'staff_id',headerName:'Staff_ID',editable:false,type:'number'},
    {field: 'name',headerName:'Tên',width: 100,editable:true},
    {field: 'address',headerName:'Địa chỉ',width: 100,editable:true},
    {field: 'dob',headerName:'Ngày sinh',width: 100,editable:true},
    {field: 'gender',headerName:'Giới tính',width: 100,type:'singleSelect',valueOptions:['Nam','Nữ','Khác'],editable:true},
    {field: 'phone',headerName:'Điện thoại',width: 100,editable:true},
    {field: 'position',headerName:'Chức vụ',width: 100,editable:true},
    {field: 'salary',headerName:'Lương tháng',width: 100,editable:true},
    {field: 'account_id',headerName:'Account_ID',width: 100,type:'number',editable:true},
    { 
      field:'actions',
      type:'actions',
      headerName:'Actions',
      width:200,
      getActions:({id})=>{
        const isInEditMode = rowModesModel[id]?.mode === GridRowModes.Edit;
        if(isInEditMode){
          return [
            <GridActionsCellItem
              icon={<SaveIcon/>}
              onClick={onSaveClickListener.bind(this,id)}
              label='Save'
            />,
            <GridActionsCellItem
              icon={<CancelIcon/>}
              onClick={onCancelClickListener.bind(this,id)}
              label='Cancel'
            />,
          ];
        }
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
  function handleOnAddClick(event){
    event.preventDefault();
    navigate("../addstaff",{replace:true});
  }
  function processRowUpdate(){

  }
  function handleRowModesModelChange(){

  }
  function onEditClickListener(){

  }
  function onDeleteClickListener(){

  }
  function onSaveClickListener(){

  }
  function onCancelClickListener(){

  }
  return (
    <div className='main-content'>
      <div className='content'>
        <span className='title'>Danh sách nhân viên</span>
      </div>
      <div className='crud-table'>
        <div className='crud-button'>
          <Button onClick={handleOnAddClick} variant='outlined'>Thêm</Button>
        </div>
        <DataGrid
          className=''
          getRowId={getRowId}
          columns={columns}
          rows={stafflist}
          rowModesModel={rowModesModel}
          getRowHeight={() => 'auto'}
          onRowModesModelChange={handleRowModesModelChange}
          processRowUpdate={processRowUpdate}
          onProcessRowUpdateError={err=>console.log(err)}
          editMode='row'
          pageSize={10}
          slots={{toolbar:GridToolbar}}
          disableRowSelectionOnClick
          disableColumnFilter
          disableDensitySelector
        />
      </div>
    </div>
    


  )
}


export default Employee