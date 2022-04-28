package com.productapp.repository;

import com.productapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer>{
    
	@Query("from Product p where p.category LIKE ?1 or p.brand LIKE ?1")
	List<Product> findByChoice(String choice);

	List<Product> findByCategory(String category);
    
	List<Product> findByPriceLessThan(double price);
    
	List<Product> findByBrandStartingWith(String brand);

	List<Product> findByBrand(String brand);
}
