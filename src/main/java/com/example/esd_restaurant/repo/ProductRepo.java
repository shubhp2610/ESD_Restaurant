package com.example.esd_restaurant.repo;
import com.example.esd_restaurant.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM product WHERE price BETWEEN 15 AND 30 ORDER BY price DESC LIMIT 2", nativeQuery = true)
    List<Product> findTop2Products();
}
