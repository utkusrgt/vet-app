package com.vetapp.vetapp.repository;

import com.vetapp.vetapp.entity.AvailableDate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailableDateRepository extends JpaRepository<AvailableDate, Long> {
}