package com.jpa.example.spring_hibernate_props.repository;

import com.jpa.example.spring_hibernate_props.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
