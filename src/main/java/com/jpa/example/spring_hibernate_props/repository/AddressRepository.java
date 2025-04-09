package com.jpa.example.spring_hibernate_props.repository;

import com.jpa.example.spring_hibernate_props.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
