package com.reactapp.techshopapi.service;

import com.reactapp.techshopapi.model.Account;
import com.reactapp.techshopapi.model.Staff;

public interface StaffService {
    public Staff getStafffromAccount(Account account);
    public boolean editStaff(Staff staff);
}
