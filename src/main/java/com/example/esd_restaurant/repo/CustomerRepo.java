package com.example.esd_restaurant.repo;
import com.example.esd_restaurant.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
