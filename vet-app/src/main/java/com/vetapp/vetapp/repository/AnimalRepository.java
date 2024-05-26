package com.vetapp.vetapp.repository;

import com.vetapp.vetapp.entity.Animal;
import com.vetapp.vetapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    Optional<Animal> findByNameAndCustomer(String name, Customer owner);

    @Query("SELECT a FROM Animal a JOIN a.customer c WHERE c.id = :customerId")
    List<Animal> findByCustomerId(@Param("customerId") Long customerId);

    @Query("SELECT a FROM Animal a WHERE a.customer.name = :customerName")
    List<Animal> findByCustomerName(@Param("customerName") String customerName);

    //Optional<Object> findByName(String name);

    List<Animal> findByName(String name);



    @Query("SELECT a FROM Animal a WHERE a.name = :name AND a.customer.id = :customerId")
    Animal findByAnimalNameAndCustomerId(@Param("name") String name, @Param("customerId") Long customerId);
}