package com.vetapp.vetapp.controller;

import com.vetapp.vetapp.dto.request.AddDatesRequest;
import com.vetapp.vetapp.entity.Doctor;
import com.vetapp.vetapp.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;



    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorService.findAll();
        return ResponseEntity.ok(doctors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        Doctor doctor = doctorService.getById(id);
        return ResponseEntity.ok(doctor);
    }

    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        Doctor createdDoctor = doctorService.create(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDoctor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
        Doctor updatedDoctor = doctorService.update(id, doctor);
        return ResponseEntity.ok(updatedDoctor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteById(id);
        return ResponseEntity.ok("Doctor with ID " + id + " has been deleted successfully.");
    }

    @PostMapping("/{id}/add-date")
    public ResponseEntity<Doctor> addDate(@PathVariable Long id, @RequestBody Doctor doctor) {
        Doctor updatedDoctor = doctorService.addDate(id, doctor);
        return ResponseEntity.ok(updatedDoctor);


    }

    @PostMapping("/add-dates")
    public ResponseEntity<Doctor> addDates(@RequestBody AddDatesRequest request) {
        Doctor updatedDoctor = doctorService.addDatesToDoctor(request.getDoctorId(), request.getDates());
        return ResponseEntity.ok(updatedDoctor);
    }


    @GetMapping("/by-date")
    public ResponseEntity<List<Doctor>> getDoctorsByAvailableDate(@RequestParam("date") LocalDate date) {
        List<Doctor> doctors = doctorService.findDoctorsByAvailableDate(date);
        return ResponseEntity.ok(doctors);
    }


}
