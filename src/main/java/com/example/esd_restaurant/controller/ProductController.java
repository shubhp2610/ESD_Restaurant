package com.example.esd_restaurant.controller;

import com.example.esd_restaurant.dto.ProductRequest;
import com.example.esd_restaurant.entity.Product;
import com.example.esd_restaurant.helper.AuthHelper;
import com.example.esd_restaurant.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;
    private final AuthHelper authHelper;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest.ProductRequestBody productCreateRequest) {
        return ResponseEntity.ok(productService.createProduct(productCreateRequest));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id , @RequestBody @Valid ProductRequest.ProductRequestBody productUpdateRequest) {
        Product product = productService.updateProduct(id, productUpdateRequest);
        if(product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        Boolean deleted = productService.deleteProduct(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Product Deleted Successfully!");
    }

    @GetMapping("/top-2-products")
    public ResponseEntity<List<Product>> getTopProducts() {
        return ResponseEntity.ok(productService.getTop2Products());
    }
}
