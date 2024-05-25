package com.vetapp.vetapp.service.interfaces;

import com.vetapp.vetapp.dto.request.CustomerRequest;
import com.vetapp.vetapp.dto.response.CustomerResponse;
import com.vetapp.vetapp.entity.Vaccine;

import java.time.LocalDate;
import java.util.List;

public interface VaccineService {
    List<Vaccine> findAll();
    Vaccine getById(Long id);
    Vaccine create(Vaccine vaccine);
    List<Vaccine> getVaccinesByAnimalId(Long animalId);
    List<Vaccine> getVaccinesByProtectionEndDateRange(LocalDate startDate, LocalDate endDate);
    Vaccine update(Long id, Vaccine vaccine);
}
