package com.vetapp.vetapp.repository;

import com.vetapp.vetapp.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
}