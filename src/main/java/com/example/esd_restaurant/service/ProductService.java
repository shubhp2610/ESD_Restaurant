package com.example.esd_restaurant.service;

import com.example.esd_restaurant.dto.ProductRequest;
import com.example.esd_restaurant.entity.Product;
import com.example.esd_restaurant.mapper.ProductMapper;
import com.example.esd_restaurant.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo repo;
    private final ProductMapper mapper;
    public Product createProduct(ProductRequest.ProductRequestBody request) {
        Product product = mapper.toEntity(request);
        product = repo.save(product);
        return product;
    }

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Product updateProduct(Long id, ProductRequest.ProductRequestBody request) {
        Product product = getProductById(id);
        if(product != null) {
            product.setName(request.name());
            product.setPrice(request.price());
            product.setUpdatedOn(LocalDateTime.now());
            }
        return product!=null?repo.save(product):null;
    }

    public boolean deleteProduct(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }


}

