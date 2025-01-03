package com.vamikastore.vamika.controllers;

import com.vamikastore.vamika.dto.ProductDto;
import com.vamikastore.vamika.entities.Product;
import com.vamikastore.vamika.services.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> productList = productService.getAllProducts();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    // create Product
    @PostMapping
    public ProductDto createProduct(@RequestBody Product product){
        return null;
    }
}
