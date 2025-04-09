package com.jpa.example.spring_hibernate_props.service;

import com.jpa.example.spring_hibernate_props.entity.Customer;
import com.jpa.example.spring_hibernate_props.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Transactional
    public Customer saveCustomer(Customer customer) {
        if (customer.getAddresses() != null) {
            customer.getAddresses().forEach(
                    address -> address.setCustomer(customer)
            );
        }
        return customerRepository.save(customer);
    }

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Customer not found..."));
    }

    public Optional<Customer> getCustomerById(Long id) {
        return Optional.ofNullable(customerRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Customer not found...")
        ));
    }

    public Optional<Customer> getCustomerByIdWithAddresses(Long id) {
        return Optional.ofNullable(customerRepository.fetchByIdWithAddresses(id).orElseThrow(
                () -> new RuntimeException("Customer not found...")
        ));
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public List<Customer> fetchAllWithAddresses() {
        return customerRepository.fetchCustomersWithAddresses();
    }

}
