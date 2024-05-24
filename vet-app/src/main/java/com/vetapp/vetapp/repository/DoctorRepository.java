package com.vetapp.vetapp.repository;

import com.vetapp.vetapp.entity.Customer;
import com.vetapp.vetapp.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Optional<Doctor> findByNameAndPhoneAndMail(String name, String phone, String mail);

    @Query("SELECT d FROM Doctor d JOIN d.availableDates ad WHERE ad.availableDate = :date")
    List<Doctor> findDoctorsByAvailableDate(@Param("date") LocalDate date);
}