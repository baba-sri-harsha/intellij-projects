package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.model.Product;
import com.productapp.repository.IProductRepository;

@Service
public class ProductServiceImpl  implements IProductService{
	
	
	    
	    private IProductRepository productRepository;
	    @Autowired
		public void setProductRepository(IProductRepository productRepository) {
			this.productRepository = productRepository;
		}

		@Override
	    public void addProduct(Product product) {
	        productRepository.save(product);
	    }

	    @Override
	    public void updateProduct(Product product) {
	        productRepository.save(product);
	    }

	    @Override
	    public void deleteProduct(int productId) {
	        productRepository.deleteById(productId);
	    }

	    @Override
	    public List<Product> getAll() {
	        
	        return productRepository.findAll();
	    }

	    @Override
	    public Product getById(int productId)  {
	        
	        return productRepository.getById(productId);
	    }

	    @Override
	    public List<Product> getByChoice(String choice)  {
	      
	        return productRepository.findByChoice("%"+choice+"%");
	    }

	    @Override
	    public List<Product> getByCategory(String category)  {
	     
	        return productRepository.findByCategory(category);
	    }

	    @Override
	    public List<Product> getByLesserprice(double price)  {

	        return productRepository.findByPriceLessThan(price);
	    }

	    @Override
	    public List<Product> getByBrandStarting(String brand)  {
	        
	        return productRepository.findByBrandStartingWith(brand);
	    }

		@Override
		public List<Product> getByBrand(String brand) {
			return productRepository.findByBrand(brand);
		}


}
