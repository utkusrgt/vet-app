package com.vetapp.vetapp.repository;

import com.vetapp.vetapp.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    boolean existsByDoctorIdAndAppointmentDate(Long doctorId, LocalDateTime appointmentDate);
    boolean existsByDoctorIdAndAppointmentDateAndIdNot(Long doctorId, LocalDateTime appointmentDate, Long id);
    List<Appointment> findByAppointmentDateBetweenAndDoctorId(LocalDateTime startDate, LocalDateTime endDate, Long doctorId);
    List<Appointment> findByAppointmentDateBetweenAndAnimalId(LocalDateTime startDate, LocalDateTime endDate, Long animalId);

    List<Appointment> findByDoctorIdAndAppointmentDateBetween(Long id, LocalDateTime localDateTime, LocalDateTime appointmentEnd);


    @Query("SELECT a FROM Appointment a WHERE DATE(a.appointmentDate) = :appointmentDate AND a.doctor.id = :doctorId")
    List<Appointment> findByAppointmentDateAndDoctorId(@Param("appointmentDate") LocalDate appointmentDate, @Param("doctorId") Long doctorId);

    @Query("SELECT a FROM Appointment a WHERE DATE(a.appointmentDate) = :appointmentDate AND a.animal.id = :animalId")
    List<Appointment> findByAppointmentDateAndAnimalId(LocalDate appointmentDate, Long animalId);
}