package com.example.esd_restaurant.service;

import com.example.esd_restaurant.dto.CustomerRequest;
import com.example.esd_restaurant.entity.Customer;
import com.example.esd_restaurant.helper.JWTHelper;
import com.example.esd_restaurant.mapper.CustomerMapper;
import com.example.esd_restaurant.repo.CustomerRepo;
import com.example.esd_restaurant.helper.EncryptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final EncryptionService encryptionService;
    private final JWTHelper jwHelper;
    private final CustomerRepo repo;
    private final CustomerMapper mapper;
    public Customer createCustomer(CustomerRequest.CustomerCreateRequest request) {
        Customer customer = mapper.toEntity(request);
        customer.setPassword(encryptionService.encode(customer.getPassword()));
        customer = repo.save(customer);
        return customer;
    }

    public String loginCustomer(CustomerRequest.CustomerLoginRequest request) {
        Optional<Customer> optionalCustomer = repo.findByEmail(request.email());

        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            if (encryptionService.validates(request.password(), customer.getPassword())) {
                return jwHelper.generateToken(customer.getEmail());
            } else {
                return "Invalid password";
            }
        } else {
            return "User not found";
        }
    }


}
