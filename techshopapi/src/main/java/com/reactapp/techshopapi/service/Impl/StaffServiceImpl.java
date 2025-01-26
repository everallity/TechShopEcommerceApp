package com.reactapp.techshopapi.service.Impl;

import com.reactapp.techshopapi.model.Account;
import com.reactapp.techshopapi.model.Staff;
import com.reactapp.techshopapi.respositories.Impl.StaffDAOImpl;
import com.reactapp.techshopapi.respositories.StaffDAO;
import com.reactapp.techshopapi.service.StaffService;

public class StaffServiceImpl implements StaffService {
    private StaffDAO staffDAO=new StaffDAOImpl();
    @Override
    public Staff getStafffromAccount(Account account) {
        return staffDAO.getStafffromAccount(account);
    }

    @Override
    public boolean editStaff(Staff staff) {
        return staffDAO.updateStaff(staff);
    }
}
