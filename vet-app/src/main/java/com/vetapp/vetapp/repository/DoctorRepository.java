package com.vetapp.vetapp.repository;

import com.vetapp.vetapp.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}