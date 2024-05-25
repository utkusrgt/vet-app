package com.vetapp.vetapp.controller;

import com.vetapp.vetapp.entity.Appointment;
import com.vetapp.vetapp.service.impl.AppointmentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentServiceImpl appointmentService;

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> appointments = appointmentService.findAll();
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        Appointment appointment = appointmentService.getById(id);
        return ResponseEntity.ok(appointment);
    }

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        Appointment createdAppointment = appointmentService.create(appointment);
        return ResponseEntity.ok(createdAppointment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
        Appointment updatedAppointment = appointmentService.update(id, appointment);
        return ResponseEntity.ok(updatedAppointment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByDateRangeAndDoctor(
            @RequestParam("appointmentDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate appointmentDate,
            @PathVariable Long doctorId) {
        List<Appointment> appointments = appointmentService.findByAppointmentDateAndDoctorId(appointmentDate, doctorId);
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/animal/{animalId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByDateRangeAndAnimal(
            @RequestParam("appointmentDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate appointmentDate,
            @PathVariable Long animalId) {
        List<Appointment> appointments = appointmentService.findByAppointmentDateAndAnimalId(appointmentDate, animalId);
        return ResponseEntity.ok(appointments);
    }
}
