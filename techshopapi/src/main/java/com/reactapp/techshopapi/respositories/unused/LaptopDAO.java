package com.reactapp.techshopapi.respositories.unused;

import com.reactapp.techshopapi.model.unused.Laptop;

import java.util.List;

public interface LaptopDAO {
    public boolean add(Laptop laptop);
    public boolean delete(Laptop laptop);
    public boolean update(Laptop laptop);
    public List<Laptop> getListLaptop();
}
