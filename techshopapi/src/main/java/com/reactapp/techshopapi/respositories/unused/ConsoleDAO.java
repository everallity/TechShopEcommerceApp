package com.reactapp.techshopapi.respositories.unused;

import com.reactapp.techshopapi.model.unused.Console;

import java.util.List;

public interface ConsoleDAO {
    public boolean add(Console console);
    public boolean delete(Console console);
    public boolean update(Console console);
    public List<Console> getListConsole();
}
