package com.vetapp.vetapp.service.impl;

import com.vetapp.vetapp.entity.Vaccine;
import com.vetapp.vetapp.repository.VaccineRepository;
import com.vetapp.vetapp.service.interfaces.VaccineService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VaccineServiceImpl implements VaccineService {

    private final VaccineRepository vaccineRepository;

    public List<Vaccine> findAll() {
        return vaccineRepository.findAll();
    }

    public Vaccine getById(Long id) {
        return vaccineRepository.findById(id).orElseThrow(() -> new RuntimeException(id + " vaccine !!!"));
    }

    @Transactional
    public Vaccine create(Vaccine vaccine) {
        Optional<Vaccine> isVaccineExists = vaccineRepository.findViableVaccineByAnimalIdAndCode(vaccine.getAnimal().getId(), vaccine.getCode());

        if (isVaccineExists.isEmpty()) {
            return this.vaccineRepository.save(vaccine);
        }
        throw new RuntimeException("This vaccine is still viable!");
    }

    public List<Vaccine> getVaccinesByAnimalId(Long animalId) {
        return vaccineRepository.findByAnimalId(animalId);
    }

    public List<Vaccine> getVaccinesByProtectionEndDateRange(LocalDate startDate, LocalDate endDate) {
        return vaccineRepository.findVaccinesByProtectionEndDateRange(startDate, endDate);
    }

    public Vaccine update(Long id, Vaccine vaccine) {

        Optional<Vaccine> vaccineFromDb = vaccineRepository.findById(id);

        if (vaccineFromDb.isEmpty()) {
            throw new RuntimeException(id + " vaccine could not found !!!.");
        }

        vaccine.setId(id);
        return this.vaccineRepository.save(vaccine);
    }


}
