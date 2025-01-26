import React from 'react'
import { DataGrid,GridToolbar,GridRowModes,GridActionsCellItem} from '@mui/x-data-grid'
import Button from '@mui/material/Button'
import AddIcon from '@mui/icons-material/Add';
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/DeleteOutlined';
import SaveIcon from '@mui/icons-material/Save';
import CancelIcon from '@mui/icons-material/Close';
import { Box } from '@mui/material';
import './index.css'
import { useEffect,useState } from 'react';
import { renderTimeViewClock } from '@mui/x-date-pickers';
import ProductDetails from '../productdetails/ProductDetails';
import { useGridApiRef,useGridApiContext } from '@mui/x-data-grid';
import { useLocation, useNavigate } from 'react-router-dom';
const Product = () => {
  const location=useLocation();
  let account=null;
  account=location.state.account;
  console.log('product'+account.username);
  function getRowId(row){
    return row.product_id;
  }
  const rows=[
    {id:1 , col1:'s',col2:'s', col3:'s',col4:'s',col5:'s' },
  ];
  const [rowModesModel,setRowModesModel]=useState({});
  const [productlist,setproductlist]=useState({});
  const navigate=useNavigate();
  const apiRef=useGridApiRef();
  let reloadflag=false;
  function loadData(){
    fetch("http://localhost:8080/product/getlistproduct")
      .then(res=>{
        console.log(res)
        if(res.ok){
          let data=res.json();
          return data;
        }
      })
      .then(data=>{
        console.log(data);
        setproductlist(data);
        return data;
      })
      .catch(err=>{
        console.log(err);
      })
  }
  useEffect(()=>{
    loadData();
  },[]);
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
    fetch("http://localhost:8080/product/deleteproduct",fetchOptions)
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
  function editData(){

  }
  const columns=[
    {field:'product_id',headerName:'Product_ID',editable:false,type:'number'},
    {field: 'name',headerName:'Tên',width: 150,editable:true},
    {field: 'brand',headerName:'Thương hiệu',width: 100,editable:true},
    {field: 'category',headerName:'Chủng loại',width: 100,editable:true,type:'singleSelect',valueOptions:['Console','Phone','PC','Mobile','Accesories']},
    {
      field: 'image',
      headerName:'Thumbnail',
      width: 150,
      editable:true,
      cellClassName:"product_thumbnail",
      renderCell:(params)=>{
        return(
          <div className='product_thumbnail'>
            <img src={params.value} alt="thumbnail" loading='lazy'/>
          </div> 
        )
      
      }  
    },
    {field: 'stock',headerName:'Tồn kho',width: 100,type:'number',editable:true},
    {field: 'price',headerName:'Đơn giá',width: 100,type:'number',editable:true},
    {field: 'description',headerName:'Mô tả',width: 250,editable:true},
    { 
      field:'actions',
      type:'actions',
      headerName:'Actions',
      cellClassName:'actions',
      width:100,
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
  function onCancelClickListener(id){
    setRowModesModel({
      ...rowModesModel,
      [id]: { mode: GridRowModes.View, ignoreModifications: true },
    });
  }
  
  function onSaveClickListener(id){
    setRowModesModel({ ...rowModesModel, [id]: { mode: GridRowModes.View } });
  }
  function onDeleteClickListener(id){
    console.log(id);
    const deletedRow=productlist.find((row)=>
      row.product_id===id
    )
    console.log(deletedRow);
    deleteData(deletedRow);
  }
  function onEditClickListener(id){
    console.log(id);
    const editRow=productlist.find((row)=>row.product_id===id);
    console.log(editRow);
    navigate("../productdetails",{state:{editRow,account},replace:true},);

   // setRowModesModel({ ...rowModesModel, [id]: { mode: GridRowModes.Edit } });
   // editData();
  }
  function handleRowModesModelChange(newRowModesModel){
    setRowModesModel(newRowModesModel);
  }
  function processRowUpdate(newRow){
    const updatedRow = { ...newRow, isNew: false };
    setproductlist(productlist.map((product) => (product.product_id === newRow.id ? updatedRow : product)));
    console.log(productlist);
    return updatedRow;
  }
  function handleOnAddClick(event){
    event.preventDefault();
    navigate("../addproduct",{replace:true,state:{account}});
  }
  return (
    <div className='main-content'>
      <div className='content'>
        <span className='title'>Danh sách sản phẩm</span>
      </div>
      <div className='crud-table'>
        <div className='crud-button'>
          <Button onClick={handleOnAddClick} variant='outlined'>Thêm</Button>
        </div>
        <Box sx={{
          width:'100%',
        }
        }>
        <DataGrid 
          className=''
          getRowId={getRowId}
          columns={columns}
          rows={productlist}
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
        </Box>
      </div>
    </div>
    


  )
}

export default Product