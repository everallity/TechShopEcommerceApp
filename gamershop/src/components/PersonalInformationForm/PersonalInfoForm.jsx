import React from 'react'
import './index.css'
const PersonalInfoForm = () => {
  return (
    <div className='container_box'>
        <div className='header'>
            <h1>Personal Information</h1>
            <hr></hr>
        </div>
        <div className='content'>
            <form className='input_form'>
                <div className='input'>
                    <label htmlFor='Username'>
                        Username:
                    </label>
                    <input type='text' id='Username'>
                    </input>
                </div>
                <div className='input'>
                    <label htmlFor=''>
                        Full name:
                    </label>
                    <input type='text'>
                    </input>
                </div>
                <div className='input'>
                    <label htmlFor=''>
                        Email:
                    </label>
                    <input type='text'>
                    </input>
                </div>
                <div className='input'>
                    <label htmlFor=''>
                        Phone:
                    </label>
                    <input type='text'>
                    </input>
                </div>
                <div className='radio_group'>
                    <label>Gender: </label>
                    <div className='option'>
                        <input type='radio' id='male'></input>
                        <label htmlFor='male'>Male</label>
                    </div>
                    <div className='option'>
                        <input type='radio' id='female'></input>
                        <label htmlFor='female'>Female</label>
                    </div>
                    <div className='option'>
                        <input type='radio' id='other'></input>
                        <label htmlFor='other'>Other</label>
                    </div>
                </div>
                <div className='input'>
                    <label htmlFor=''>
                        Phone:
                    </label>
                    <input type='text'>
                    </input>
                </div>
                <div className='input'>
                    <label htmlFor=''>
                        Address:
                    </label>
                    <input type='text'>
                    </input>
                </div>
                <div className='input'>
                    <label>
                        Date of Birth:
                        <div className='dob_option'>
                        <select name='day'>
                            <option>1</option>
                        </select>
                        <select name='month'>
                            <option>January</option>
                        </select>
                        <select name='year'>
                            <option>1990</option>
                        </select>
                        </div>
                    </label>
                    </div>
                <div className='actionbutton'>
                    <button>Save</button>
                    <button>Cancel</button>
                </div>
            </form>
            <div className='profile_pic'>
                <p>Profile Picture</p>
                <img></img>
                <button>Upload</button>
            </div>
        </div>
        
    </div>
  )
}

export default PersonalInfoForm