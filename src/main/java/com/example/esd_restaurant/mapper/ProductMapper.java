package com.example.esd_restaurant.mapper;

import com.example.esd_restaurant.dto.ProductRequest;
import com.example.esd_restaurant.entity.Product;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductMapper {
    public Product toEntity(ProductRequest.ProductRequestBody request) {
        return Product.builder()
                .name(request.name())
                .price(request.price())
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .build();
    }
}
