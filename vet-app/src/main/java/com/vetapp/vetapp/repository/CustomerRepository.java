package com.vetapp.vetapp.repository;

import com.vetapp.vetapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}