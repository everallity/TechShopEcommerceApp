package com.reactapp.techshopapi.respositories;

import com.reactapp.techshopapi.model.Account;
import com.reactapp.techshopapi.model.Staff;

import java.util.List;

public interface StaffDAO {
    public boolean addStaff(Staff staff);
    public boolean deleteStaff(Staff staff);
    public boolean updateStaff(Staff staff);
    public List<Staff> getListStaff();
    public Staff getStafffromAccount(Account account);
}
