package com.productapp.controller;

import java.util.List;


import com.productapp.execptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.productapp.model.Product;
import com.productapp.service.IProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product-api")
public class ProductController {
	
    private IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public ResponseEntity<Void> addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        ResponseEntity<Void> responseEntity =
                ResponseEntity.status(HttpStatus.CREATED).build();
        return  responseEntity;
    }

    @PutMapping("/products")
    public  ResponseEntity<Void> updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
        ResponseEntity<Void> responseEntity=
                ResponseEntity.status(HttpStatus.CREATED).build();
        return responseEntity;
    }

    @DeleteMapping("products/productId/{productId}")
    public  ResponseEntity<Void> deleteProduct(@PathVariable("productId") int productId){
        productService.deleteProduct(productId);
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","deleteing one product by id");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();

    }

    @GetMapping("products/productId/{productId}")
    public ResponseEntity<Void> getById(@PathVariable("id") int id){
        productService.getById(id);
        return (ResponseEntity<Void>) ResponseEntity.status(HttpStatus.OK);
    }


    @GetMapping("/products")
    ResponseEntity<List<Product>> getAll(){
        List<Product> products = productService.getAll();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting all products");
        headers.add("info","get all Method called");
        ResponseEntity<List<Product>> productResponse = new ResponseEntity<>(products,headers, HttpStatus.OK);
        return productResponse;
    }

    @GetMapping("/products/category/{category}")
    ResponseEntity<List<Product>> getByCategory(@PathVariable("category") String category) throws ProductNotFoundException {
        List<Product> products = productService.getByCategory(category);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Get by Category"+category);
        return ResponseEntity.ok().headers(headers).body(products);

    }
    @GetMapping("/products/brand/{brand}")
    ResponseEntity<List<Product>> getByBrand(@PathVariable("brand")String brand) throws ProductNotFoundException {
        List<Product> products = productService.getByBrand(brand);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Get by brand"+brand);
        return ResponseEntity.ok().headers(headers).body(products);

    }
    @GetMapping("/products/price/{price}")
    ResponseEntity<List<Product>> getByLesserPrice(@PathVariable("price") double price) throws ProductNotFoundException{
        List<Product> products = productService.getByLesserprice(price);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Get by lesser price"+price);
        return ResponseEntity.ok().headers(headers).body(products);

    }
    @GetMapping("/products/brand-starting/{brand}")
    ResponseEntity<List<Product>> getByBrandStarting(@PathVariable("brand")String brand) throws ProductNotFoundException{
        List<Product> products = productService.getByBrandStarting(brand);
        ResponseEntity<List<Product>> productResponse = ResponseEntity.ok().body(products);
        return productResponse;
    }
    @GetMapping("/products/choice/{choice}")
    ResponseEntity<List<Product>> getByChoice(@PathVariable("choice") String choice){
        List<Product> products = productService.getByChoice(choice);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Get by choice"+choice);
        return ResponseEntity.ok().headers(headers).body(products);
    }






}