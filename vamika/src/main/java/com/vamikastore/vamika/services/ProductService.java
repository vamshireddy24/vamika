package com.vamikastore.vamika.services;

import com.vamikastore.vamika.entities.Product;

import java.util.List;

public interface ProductService {

    public Product addProduct(Product product);
    public List<Product> getAllProducts();
}
