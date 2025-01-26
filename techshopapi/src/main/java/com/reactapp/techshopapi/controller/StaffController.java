package com.reactapp.techshopapi.controller;

import com.reactapp.techshopapi.model.Account;
import com.reactapp.techshopapi.model.Staff;
import com.reactapp.techshopapi.service.Impl.StaffServiceImpl;
import com.reactapp.techshopapi.service.StaffService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("staff/")
@CrossOrigin
public class StaffController {
    private static final StaffService staffService=new StaffServiceImpl();
    @PostMapping(value = "getstaffinfo",consumes = "multipart/form-data",produces = "application/json")
    @ResponseBody
    public Staff getStaffinfo(@RequestParam("username") String username,
                              @RequestParam("email")String email,
                              @RequestParam("password")String password,
                              @RequestParam("id")int id,
                              @RequestParam("type")int type){
        Account account=new Account();
        account.setUsername(username);
        account.setId(id);
        account.setType(type);
        account.setEmail(email);
        account.setPassword(password);
        return staffService.getStafffromAccount(account);
    }
    @PostMapping(value = "editstaff",consumes = "multipart/form-data",produces = "application/json")
    @ResponseBody
    public boolean editStaff(@RequestParam("name") String name,
                              @RequestParam("address")String address,
                              @RequestParam("dob")String dob,
                              @RequestParam("staff_id")int id,
                              @RequestParam("phone")String phone,
                             @RequestParam("gender")String gender){
        //
        Staff staff=new Staff();
        staff.setStaff_id(id);
        staff.setAddress(address);
        staff.setDob(dob);
        staff.setGender(gender);
        staff.setPhone(phone);
        staff.setName(name);
        System.out.println(staff);
        return staffService.editStaff(staff);
    }
}
