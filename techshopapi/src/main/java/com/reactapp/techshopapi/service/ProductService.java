package com.reactapp.techshopapi.service;

import com.reactapp.techshopapi.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getListProduct();
    public  boolean deleteProduct(Product product);
    public boolean updateProduct(Product product);
    public boolean addProduct(Product product);
    public List<Product> getListProductbyCategory(String category);
}
