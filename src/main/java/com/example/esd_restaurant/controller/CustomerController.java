package com.example.esd_restaurant.controller;

import com.example.esd_restaurant.dto.CustomerRequest;
import com.example.esd_restaurant.entity.Customer;
import com.example.esd_restaurant.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<Customer> createCustomer(@RequestBody @Valid CustomerRequest.CustomerCreateRequest customerCreateRequest) {
        return ResponseEntity.ok(customerService.createCustomer(customerCreateRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginCustomer(@RequestBody @Valid CustomerRequest.CustomerLoginRequest customerLoginRequest) {
        return ResponseEntity.ok(customerService.loginCustomer(customerLoginRequest));
    }
}
