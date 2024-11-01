package com.example.esd_restaurant.mapper;

import com.example.esd_restaurant.dto.CustomerRequest;
import com.example.esd_restaurant.entity.Customer;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CustomerMapper {
    public Customer toEntity(CustomerRequest.CustomerCreateRequest request) {
        return Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(request.password())
                .address(request.address())
                .city(request.city())
                .pincode(request.pincode())
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .build();
    }

    public Customer toEntity(CustomerRequest.CustomerLoginRequest request) {
        return Customer.builder()
                .email(request.email())
                .password(request.password())
                .build();
    }
}
