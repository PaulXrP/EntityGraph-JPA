package com.jpa.example.spring_hibernate_props.controller;

import com.jpa.example.spring_hibernate_props.entity.Customer;
import com.jpa.example.spring_hibernate_props.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.saveCustomer(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
        Customer customer = customerService.getCustomer(customerId);
        return new ResponseEntity<>(customer, HttpStatus.FOUND);
    }

    @GetMapping("/customised/{customerId}")
    public ResponseEntity<Optional<Customer>> getCustomerById2(@PathVariable Long customerId) {
        Optional<Customer> customer = customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customer, HttpStatus.FOUND);
    }

    @GetMapping("/fetch/{customerId}")
    public ResponseEntity<Optional<Customer>> getCustomerByIdWithAddress(@PathVariable Long customerId) {
        Optional<Customer> customer = customerService.getCustomerByIdWithAddresses(customerId);
        return new ResponseEntity<>(customer, HttpStatus.FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> allCustomers = customerService.getAllCustomers();
        return new ResponseEntity<>(allCustomers, HttpStatus.FOUND);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<Customer>> fetchAllCustomersWithAddresses() {
        List<Customer> allCustomers = customerService.fetchAllWithAddresses();
        return new ResponseEntity<>(allCustomers, HttpStatus.FOUND);
    }
}


