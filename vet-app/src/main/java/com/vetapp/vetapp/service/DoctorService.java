package com.vetapp.vetapp.service;

import com.vetapp.vetapp.entity.Animal;
import com.vetapp.vetapp.entity.AvailableDate;
import com.vetapp.vetapp.entity.Doctor;
import com.vetapp.vetapp.repository.AvailableDateRepository;
import com.vetapp.vetapp.repository.DoctorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final AvailableDateRepository availableDateRepository;

    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    public Doctor getById(Long id) {
        return doctorRepository.findById(id).orElseThrow(() -> new RuntimeException(id + " doctor could not found !!!"));
    }

    @Transactional
    /*public Doctor create(Doctor doctor) {
        Optional<Doctor> isDoctorExist = doctorRepository.findByNameAndPhoneAndMail(doctor.getName(), doctor.getPhone(), doctor.getMail());

        if (isDoctorExist.isEmpty()) {
            return this.doctorRepository.save(doctor);
        }
        throw new RuntimeException("This doctor is already exists !!!");
    }*/
    public Doctor create(Doctor doctor) {
        Optional<Doctor> isDoctorExist = doctorRepository.findByNameAndPhoneAndMail(doctor.getName(), doctor.getPhone(), doctor.getMail());

        if (isDoctorExist.isEmpty()) {
            // Create the doctor without setting availableDates
            return doctorRepository.save(new Doctor(doctor.getId(), doctor.getName(), doctor.getPhone(), doctor.getMail(), doctor.getAddress(), doctor.getCity(), doctor.getAppointments()));
        }
        throw new RuntimeException("This doctor already exists !!!");
    }

    public Doctor update(Long id, Doctor doctor) {

        Optional<Doctor> doctorFromDb = doctorRepository.findById(id);

        if (doctorFromDb.isEmpty()) {
            throw new RuntimeException(id + " doctor could not found !!!.");
        }

        doctor.setId(id);
        return this.doctorRepository.save(doctor);
    }

    public Doctor addDate(Long id, Doctor doctor) {
        Optional<Doctor> doctorFromDb = doctorRepository.findById(id);
        if (doctorFromDb.isEmpty()) {
            throw new RuntimeException(id + " doctor could not found !!!.");
        }
        doctorFromDb.get().setAvailableDates(doctor.getAvailableDates());
        return this.doctorRepository.save(doctorFromDb.get());
    }

    public void deleteById(Long id) {
        Optional<Doctor> doctorFromDb = doctorRepository.findById(id);
        if (doctorFromDb.isPresent()) {
            doctorRepository.delete(doctorFromDb.get());
        } else {
            throw new RuntimeException(id + " doctor could not found !!!");
        }
    }


    @Transactional
    /*public Doctor addDatesToDoctor(Long doctorId, List<LocalDate> dates) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException(doctorId + " doctor could not be found!"));

        List<AvailableDate> availableDates = dates.stream()
                .map(date -> {
                    AvailableDate availableDate = new AvailableDate();
                    availableDate.setAvailableDate(date);
                    availableDate.setDoctors(new ArrayList<>());
                    availableDate.getDoctors().add(doctor);
                    return availableDate;
                })
                .collect(Collectors.toList());

        availableDateRepository.saveAll(availableDates);

        doctor.getAvailableDates().addAll(availableDates);
        return doctorRepository.save(doctor);
    }*/

    public Doctor addDatesToDoctor(Long doctorId, List<LocalDate> dates) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException(doctorId + " doctor could not be found!"));

        // Filter out dates that already exist for the doctor
        List<LocalDate> existingDates = doctor.getAvailableDates().stream()
                .map(AvailableDate::getAvailableDate)
                .collect(Collectors.toList());

        List<AvailableDate> newDates = dates.stream()
                .filter(date -> !existingDates.contains(date))
                .map(date -> {
                    AvailableDate availableDate = new AvailableDate();
                    availableDate.setAvailableDate(date);
                    availableDate.setDoctors(new ArrayList<>());
                    availableDate.getDoctors().add(doctor);
                    return availableDate;
                })
                .collect(Collectors.toList());

        availableDateRepository.saveAll(newDates);

        doctor.getAvailableDates().addAll(newDates);
        return doctorRepository.save(doctor);
    }

    public List<Doctor> findDoctorsByAvailableDate(LocalDate date) {
        return doctorRepository.findDoctorsByAvailableDate(date);
    }


}
