package com.productapp.service;

import com.productapp.execptions.ProductNotFoundException;
import com.productapp.model.Product;

import java.util.List;


public interface IProductService {
	
	void addProduct(Product product);
	
	void updateProduct(Product product);
	
    void deleteProduct(int productId);
    
    List<Product> getAll();
    
    Product getById(int productId)throws ProductNotFoundException;
    
    List<Product> getByChoice(String choice) throws ProductNotFoundException;
    
    List<Product> getByCategory(String category)throws ProductNotFoundException;
    
    List<Product> getByLesserprice(double price)throws ProductNotFoundException;
    
    List<Product> getByBrandStarting(String brand)throws ProductNotFoundException;

    List<Product> getByBrand(String brand);
}


