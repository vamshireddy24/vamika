package com.vamikastore.vamika.services;

import com.vamikastore.vamika.dto.ProductDto;
import com.vamikastore.vamika.entities.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    public Product addProduct(ProductDto product);
    public List<Product> getAllProducts(UUID categoryId, UUID typeId);
}
