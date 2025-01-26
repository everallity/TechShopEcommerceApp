import React from 'react'
import { DataGrid,GridToolbar} from '@mui/x-data-grid'
import Button from '@mui/material/Button'
import AddIcon from '@mui/icons-material/Add';
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/DeleteOutlined';
import SaveIcon from '@mui/icons-material/Save';
import CancelIcon from '@mui/icons-material/Close';
import './index.css'
const columns=[
  {field:'id',headerName:'id'},
  {field: 'col1',headerName:'col1',width: 150,editable:true},
  {field: 'col2',headerName:'col2',width: 150,editable:true},
  {field: 'col3',headerName:'col3',width: 150,editable:true},
];
const rows=[
  {id:1 , col1:'s',col2:'s', col3:'s' },
];
const Review = () => {
  return (
    <div className='main-content'>
      <div className='content'>
        <span className='title'>Reviews</span>
      </div>
      <div className='crud-table'>
        <div className='crud-button'>
          <Button variant='outlined'>Add</Button>
          <Button variant='outlined'>Edit</Button>
          <Button variant='outlined'>Delete</Button>
        </div>
        <DataGrid
          className=''
          columns={columns}
          rows={rows}
          editMode='row'
          pageSize={10}
          slots={{toolbar:GridToolbar}}
          checkboxSelection
          disableRowSelectionOnClick
        />
        <div className='database-access'>
          <Button variant='outlined'>Save</Button>
          <Button variant='outlined'>Reset</Button>
        </div>
      </div>
    </div>
    


  )
}


export default Review