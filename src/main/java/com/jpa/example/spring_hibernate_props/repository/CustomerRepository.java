package com.jpa.example.spring_hibernate_props.repository;

import com.jpa.example.spring_hibernate_props.entity.Customer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @EntityGraph(attributePaths = "addresses")
    List<Customer> findAll();

    @Query("SELECT c FROM Customer c LEFT JOIN FETCH c.addresses")
    List<Customer> fetchCustomersWithAddresses();

    @EntityGraph(attributePaths = "addresses")
    Optional<Customer> findById(Long id);

    @Query("SELECT c FROM Customer c LEFT JOIN FETCH c.addresses WHERE c.id= :id")
    Optional<Customer> fetchByIdWithAddresses(@Param("id") Long id);
}
