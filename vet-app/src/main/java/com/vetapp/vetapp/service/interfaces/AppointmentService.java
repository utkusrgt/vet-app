package com.vetapp.vetapp.service.interfaces;

import com.vetapp.vetapp.entity.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {
    List<Appointment> findAll();
    Appointment getById(Long id);
    Appointment create(Appointment appointment);
    Appointment update(Long id, Appointment appointment);
    void deleteById(Long id);
    List<Appointment> findByAppointmentDateAndDoctorId(LocalDate appointmentDate, Long doctorId);
    List<Appointment> findByAppointmentDateAndAnimalId(LocalDate appointmentDate, Long animalId);
}
