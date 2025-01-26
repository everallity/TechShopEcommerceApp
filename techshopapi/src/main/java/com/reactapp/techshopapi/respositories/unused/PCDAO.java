package com.reactapp.techshopapi.respositories.unused;

import com.reactapp.techshopapi.model.unused.PC;

import java.util.List;

public interface PCDAO {
    public boolean add(PC pc);
    public boolean delete(PC pc);
    public boolean update(PC pc);
    public List<PC> getListPC();
}
