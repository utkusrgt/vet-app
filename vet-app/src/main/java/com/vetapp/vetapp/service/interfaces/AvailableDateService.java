package com.vetapp.vetapp.service.interfaces;

import com.vetapp.vetapp.entity.AvailableDate;

import java.util.List;

public interface AvailableDateService {

    AvailableDate update(Long id, AvailableDate availableDate);
    void deleteById(Long id);
    List<AvailableDate> findByDoctorId(Long id);
}
