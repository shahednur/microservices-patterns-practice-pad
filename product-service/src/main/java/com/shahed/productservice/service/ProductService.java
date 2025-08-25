package com.shahed.productservice.service;

import java.util.List;
import java.util.Optional;

import com.shahed.productservice.entity.Product;

public interface ProductService {

    List<Product> getAllProducts();

    Optional<Product> getProductById(Long id);

    Product createProduct(Product product);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);
}
