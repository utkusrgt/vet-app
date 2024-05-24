package com.vetapp.vetapp.repository;

import com.vetapp.vetapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByNameAndPhoneAndMail(String name, String phone, String mail);



    Optional<Object> findByName(String name);
}