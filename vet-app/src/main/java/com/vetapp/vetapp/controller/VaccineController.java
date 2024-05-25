package com.vetapp.vetapp.controller;

import com.vetapp.vetapp.entity.Vaccine;
import com.vetapp.vetapp.service.impl.VaccineServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/vaccines")
@RequiredArgsConstructor
public class VaccineController {

    private final VaccineServiceImpl vaccineService;

    @GetMapping
    public ResponseEntity<List<Vaccine>> findAll() {
        List<Vaccine> vaccines = vaccineService.findAll();
        return new ResponseEntity<>(vaccines, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vaccine> getById(@PathVariable Long id) {
        Vaccine vaccine = vaccineService.getById(id);
        return new ResponseEntity<>(vaccine, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Vaccine> create(@RequestBody Vaccine vaccine) {
        Vaccine createdVaccine = vaccineService.create(vaccine);
        return new ResponseEntity<>(createdVaccine, HttpStatus.CREATED);
    }

    @GetMapping("/animal/{animalId}")
    public ResponseEntity<List<Vaccine>> getVaccinesByAnimalId(@PathVariable Long animalId) {
        List<Vaccine> vaccines = vaccineService.getVaccinesByAnimalId(animalId);
        return new ResponseEntity<>(vaccines, HttpStatus.OK);
    }

    @GetMapping("/protection-end-date")
    public ResponseEntity<List<Vaccine>> getVaccinesByProtectionEndDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        List<Vaccine> vaccines = vaccineService.getVaccinesByProtectionEndDateRange(startDate, endDate);
        return new ResponseEntity<>(vaccines, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vaccine> update(@PathVariable Long id, @RequestBody Vaccine vaccine) {
        Vaccine updatedVaccine = vaccineService.update(id, vaccine);
        return new ResponseEntity<>(updatedVaccine, HttpStatus.OK);
    }
}