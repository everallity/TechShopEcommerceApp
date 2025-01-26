package com.reactapp.techshopapi.respositories;

import com.reactapp.techshopapi.model.Product;

import java.util.List;

public interface ProductDAO {
    public boolean add(Product product);
    public boolean delete(Product product);
    public boolean update(Product product);
    public List<Product> getListProduct();
    public List<Product> getListProductbyCategory(String category);
    public Product getProductbyId(int product_id);
}
