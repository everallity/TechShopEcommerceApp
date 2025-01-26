package com.reactapp.techshopapi.service.Impl;

import com.reactapp.techshopapi.model.Product;
import com.reactapp.techshopapi.respositories.Impl.ProductDAOImpl;
import com.reactapp.techshopapi.respositories.ProductDAO;
import com.reactapp.techshopapi.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDAO productDAO=new ProductDAOImpl();
    @Override
    public List<Product> getListProduct() {
        List<Product> products=productDAO.getListProduct();
        return products;
    }

    @Override
    public boolean deleteProduct(Product product) {
        return productDAO.delete(product);
    }

    @Override
    public boolean updateProduct(Product product) {
        return productDAO.update(product);
    }

    @Override
    public boolean addProduct(Product product) {
        return productDAO.add(product);
    }

    @Override
    public List<Product> getListProductbyCategory(String category) {
        return productDAO.getListProductbyCategory(category);
    }

}
