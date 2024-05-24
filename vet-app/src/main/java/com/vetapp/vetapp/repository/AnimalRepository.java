package com.vetapp.vetapp.repository;

import com.vetapp.vetapp.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}