package com.shahed.productservice.controller;

import com.shahed.productservice.common.ApiResponse;
import com.shahed.productservice.entity.Product;
import com.shahed.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
@Validated
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ApiResponse<Product>> createProduct(@RequestBody Product product) {
        log.info("Creating product: {}", product.getName());
        Product saved = productService.createProduct(product);
        return ResponseEntity.ok(ApiResponse.ok("Product created successfully", saved));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Product>>> getAllProducts() {
        log.info("Fetching all products");
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(ApiResponse.ok("Products retrieved successfully", products));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> getProductById(@PathVariable Long id) {
        log.info("Fetching product with ID: {}", id);
        return productService.getProductById(id)
                .map(product -> ResponseEntity.ok(ApiResponse.ok("Product retrieved successfully", product)))
                .orElse(ResponseEntity.ok(ApiResponse.fail("Product not found")));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProduct(@PathVariable Long id) {
        log.info("Deleting product with ID: {}", id);
        productService.deleteProduct(id);
        return ResponseEntity.ok(ApiResponse.ok("Product deleted successfully", null));
    }
}
