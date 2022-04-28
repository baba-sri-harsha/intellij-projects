package com.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class GreetController {

    @GetMapping("/")
    public  String greetUser() {
        return "Welcome to my page";
    }

    @GetMapping("/products")
    public List<String> showProducts() {
        return Arrays.asList("Mobile","Laptop","KeyChain");
    }

    @GetMapping("/products/gadgets")
    public List<String> showPGadgets() {
        return Arrays.asList("Mobile","Laptop");
    }

    @GetMapping("/admin/add-product")
    public String addProduct() {
        return "Product added Successfully";
    }

    @GetMapping("/admin/update-product")
    public String updateProduct() {
        return "Product updated Successfully";
    }



}
