package com.reactapp.techshopapi.respositories.unused;

import com.reactapp.techshopapi.model.unused.Phone;

import java.util.List;

public interface PhoneDAO {
    public boolean add(Phone phone);
    public boolean delete(Phone phone);
    public boolean update(Phone phone);
    public List<Phone> getListPhone();
}
