package com.vetapp.vetapp.service;


import com.vetapp.vetapp.entity.Animal;
import com.vetapp.vetapp.entity.AvailableDate;
import com.vetapp.vetapp.repository.AvailableDateRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AvailableDateService {

    private final AvailableDateRepository availableDateRepository;




    /*@Transactional
    public AvailableDate create(AvailableDate availableDate) {
        Optional<AvailableDate> isDateExist = availableDateRepository.findByDoctorsAndAvailableDate(availableDate.getDoctors(), availableDate.getAvailableDate());

        if (isDateExist.isEmpty()) {
            return this.availableDateRepository.save(availableDate);
        }
        throw new RuntimeException(" This date already exists !!!");
    }*/

    public AvailableDate update(Long id, AvailableDate availableDate) {

        Optional<AvailableDate> dateFromDb = availableDateRepository.findById(id);

        if (dateFromDb.isEmpty()) {
            throw new RuntimeException(id + " date could not found !!!.");
        }

        availableDate.setId(id);
        return this.availableDateRepository.save(availableDate);
    }

    public void deleteById(Long id) {
        Optional<AvailableDate> dateFromDb = availableDateRepository.findById(id);
        if (dateFromDb.isPresent()) {
            availableDateRepository.delete(dateFromDb.get());
        } else {
            throw new RuntimeException(id + " date could not found !!!");
        }
    }

    public List<AvailableDate> findByDoctorId(Long id) {
        return availableDateRepository.findByDoctorsId(id);
    }



}
