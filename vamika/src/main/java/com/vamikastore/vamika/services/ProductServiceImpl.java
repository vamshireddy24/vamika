package com.vamikastore.vamika.services;

import com.vamikastore.vamika.entities.Product;
import com.vamikastore.vamika.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        return null;
    }

    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
//            To-do mapping of products into productDto
        return products;
    }
}
