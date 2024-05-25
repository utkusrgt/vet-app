package com.vetapp.vetapp.service.impl;


import com.vetapp.vetapp.entity.Appointment;
import com.vetapp.vetapp.entity.Doctor;
import com.vetapp.vetapp.entity.Animal;
import com.vetapp.vetapp.repository.AppointmentRepository;
import com.vetapp.vetapp.repository.AvailableDateRepository;
import com.vetapp.vetapp.repository.DoctorRepository;
import com.vetapp.vetapp.repository.AnimalRepository;
import com.vetapp.vetapp.service.interfaces.AppointmentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final AnimalRepository animalRepository;
    private final AvailableDateRepository availableDateRepository;

    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    public Appointment getById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " appointment could not be found!"));
    }

    @Transactional
    public Appointment create(Appointment appointment) {
        Doctor doctor = doctorRepository.findById(appointment.getDoctor().getId())
                .orElseThrow(() -> new RuntimeException("Doctor not found!"));
        Animal animal = animalRepository.findById(appointment.getAnimal().getId())
                .orElseThrow(() -> new RuntimeException("Animal not found!"));

        // Check if the doctor is available on the given date
        boolean isDoctorAvailable = doctor.getAvailableDates().stream()
                .anyMatch(date -> date.getAvailableDate().equals(appointment.getAppointmentDate().toLocalDate()));

        if (!isDoctorAvailable) {
            throw new RuntimeException("Doctor is not available on the specified date!");
        }


        /*
        // Check if the doctor has another appointment at the given date and time
        boolean isTimeSlotTaken = appointmentRepository.existsByDoctorIdAndAppointmentDate(
                doctor.getId(), appointment.getAppointmentDate());

        if (isTimeSlotTaken) {
            throw new RuntimeException("Doctor already has an appointment at the specified time!");
        }
        */

        // Check for overlapping appointments within one hour before and after the desired appointment time
        LocalDateTime appointmentStart = appointment.getAppointmentDate();
        LocalDateTime appointmentEnd = appointmentStart.plusHours(1);
        List<Appointment> overlappingAppointments = appointmentRepository.findByDoctorIdAndAppointmentDateBetween(
                doctor.getId(), appointmentStart.minusHours(1), appointmentEnd);

        if (!overlappingAppointments.isEmpty()) {
            throw new RuntimeException("Doctor already has an appointment within one hour of the specified time!");
        }

        appointment.calculateEndDate();
        appointment.setDoctor(doctor);
        appointment.setAnimal(animal);
        return appointmentRepository.save(appointment);
    }

    public Appointment update(Long id, Appointment appointment) {
        Appointment existingAppointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " appointment could not be found!"));

        Doctor doctor = doctorRepository.findById(appointment.getDoctor().getId())
                .orElseThrow(() -> new RuntimeException("Doctor not found!"));
        Animal animal = animalRepository.findById(appointment.getAnimal().getId())
                .orElseThrow(() -> new RuntimeException("Animal not found!"));

        // Check if the doctor is available on the given date
        boolean isDoctorAvailable = doctor.getAvailableDates().stream()
                .anyMatch(date -> date.getAvailableDate().equals(appointment.getAppointmentDate().toLocalDate()));

        if (!isDoctorAvailable) {
            throw new RuntimeException("Doctor is not available on the specified date!");
        }

        // Check if the doctor has another appointment at the given date and time, excluding the current appointment
        boolean isTimeSlotTaken = appointmentRepository.existsByDoctorIdAndAppointmentDateAndIdNot(
                doctor.getId(), appointment.getAppointmentDate(), id);

        if (isTimeSlotTaken) {
            throw new RuntimeException("Doctor already has an appointment at the specified time!");
        }
        existingAppointment.calculateEndDate();
        existingAppointment.setAppointmentDate(appointment.getAppointmentDate());
        existingAppointment.setDoctor(doctor);
        existingAppointment.setAnimal(animal);
        return appointmentRepository.save(existingAppointment);
    }

    public void deleteById(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " appointment could not be found!"));
        appointmentRepository.delete(appointment);
    }

    public List<Appointment> findByAppointmentDateAndDoctorId(LocalDate appointmentDate, Long doctorId) {
        return appointmentRepository.findByAppointmentDateAndDoctorId(appointmentDate, doctorId);
    }

    public List<Appointment> findByAppointmentDateAndAnimalId(LocalDate appointmentDate, Long animalId) {
        return appointmentRepository.findByAppointmentDateAndAnimalId(appointmentDate, animalId);
    }

}

