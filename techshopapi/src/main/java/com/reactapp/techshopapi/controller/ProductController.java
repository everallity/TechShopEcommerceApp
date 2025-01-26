package com.reactapp.techshopapi.controller;

import com.reactapp.techshopapi.model.Product;
import com.reactapp.techshopapi.service.Impl.ProductServiceImpl;
import com.reactapp.techshopapi.service.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("product/")
public class ProductController {
    private static ProductService productService=new ProductServiceImpl();
    @GetMapping(value ="getlistproduct" ,produces ="application/json" )
    @ResponseBody
    public List<Product> getListProduct(){
        System.out.println("Called get list");
        List<Product> products=new ArrayList<>();
        products=productService.getListProduct();
        return products;
    }
    @PostMapping(value = "deleteproduct")
    @ResponseBody
    public boolean deleteProduct(@RequestBody Product product){
        System.out.println("Called delete product"+product.toString());
        return productService.deleteProduct(product);
    }
    @PostMapping(value="editproduct",consumes = "multipart/form-data",produces = "application/json")
    @ResponseBody
    @CrossOrigin
    public boolean updateProduct(@RequestParam("name")String name,
                                 @RequestParam("brand")String brand,
                                 @RequestParam("category")String category,
                                 @RequestParam("price")float price,
                                 @RequestParam("stock")int stock,
                                 @RequestParam("desc")String desc,
                                 @RequestParam("productid")int id,
                                 @RequestPart(value = "file")MultipartFile file){
        try{
            if(!file.isEmpty()){
                String path="D:/techshopapi/src/main/resources/public/images/"+file.getOriginalFilename();
                Files.copy(file.getInputStream(), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
            }
            String image=file.getOriginalFilename();
            System.out.println(file.isEmpty());
            Product product=new Product(id,stock,name,brand,category,image,desc,price);
            System.out.println(product);
            return productService.updateProduct(product);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    @PostMapping(value = "addproduct",consumes = "multipart/form-data",produces = "application/json")
    @ResponseBody
    @CrossOrigin
    public boolean addproduct(@RequestParam("name")String name,
                              @RequestParam("brand")String brand,
                              @RequestParam("category")String category,
                              @RequestParam("price")float price,
                              @RequestParam("stock")int stock,
                              @RequestParam("desc")String desc,
                              @RequestPart(value = "file")MultipartFile file){
        try{
            if(!file.isEmpty()){
                String path="D:/techshopapi/src/main/resources/public/images/"+file.getOriginalFilename();
                Files.copy(file.getInputStream(), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
            }
            String image=file.getOriginalFilename();
            Product product=new Product(stock,name,brand,category,image,desc,price);
            System.out.println(product);
            return productService.addProduct(product);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    @PostMapping(value = "getproductbycategory",consumes = "multipart/form-data",produces = "application/json")
    @ResponseBody
    public List<Product> getListProductbyCategory(@RequestParam("category") String category){
        System.out.println("called");
       // category="\""+"category"+"\"";
        return productService.getListProductbyCategory(category);
    }
}
