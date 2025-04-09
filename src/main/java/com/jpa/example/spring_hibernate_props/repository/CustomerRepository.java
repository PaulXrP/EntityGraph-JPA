package com.jpa.example.spring_hibernate_props.repository;

import com.jpa.example.spring_hibernate_props.entity.Customer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @EntityGraph(attributePaths = "addresses")
    List<Customer> findAll();

    @Query("SELECT c FROM Customer c LEFT JOIN FETCH c.addresses")
    List<Customer> fetchCustomersWithAddresses();
}
