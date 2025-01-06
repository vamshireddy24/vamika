package com.vamikastore.vamika.services;

import com.vamikastore.vamika.dto.ProductDto;
import com.vamikastore.vamika.entities.Product;
import com.vamikastore.vamika.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    private ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
//            To-do mapping of products into productDto
        return products;
    }
    private Product createProduct(ProductDto productDto){
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setBrand(productDto.getBrand());
        product.setNewArrival(productDto.isNewArrival());
        product.setPrice(productDto.getPrice());

        return product;
    }
}
