package com.vetapp.vetapp.service.interfaces;

import com.vetapp.vetapp.entity.Doctor;

import java.time.LocalDate;
import java.util.List;

public interface DoctorService {

    List<Doctor> findAll();
    Doctor getById(Long id);
    Doctor create(Doctor doctor);
    Doctor update(Long id, Doctor doctor);
    void deleteById(Long id);

    Doctor addDatesToDoctor(Long doctorId, List<LocalDate> dates);
    List<Doctor> findDoctorsByAvailableDate(LocalDate date);


}
