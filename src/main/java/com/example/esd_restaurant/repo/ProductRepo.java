package com.example.esd_restaurant.repo;
import com.example.esd_restaurant.entity.Customer;
import com.example.esd_restaurant.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
