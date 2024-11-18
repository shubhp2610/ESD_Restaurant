package com.example.esd_restaurant.service;

import com.example.esd_restaurant.dto.ProductRequest;
import com.example.esd_restaurant.entity.Product;
import com.example.esd_restaurant.mapper.ProductMapper;
import com.example.esd_restaurant.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

}

