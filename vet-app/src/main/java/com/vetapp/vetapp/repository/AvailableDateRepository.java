package com.vetapp.vetapp.repository;

import com.vetapp.vetapp.entity.AvailableDate;
import com.vetapp.vetapp.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface AvailableDateRepository extends JpaRepository<AvailableDate, Long> {
    Optional<AvailableDate> findByDoctorsAndAvailableDate(Set<Doctor> doctors, LocalDate availableDate);

    List<AvailableDate> findByDoctorsId (Long id);
}