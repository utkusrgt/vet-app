package com.vetapp.vetapp.repository;

import com.vetapp.vetapp.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface VaccineRepository extends JpaRepository<Vaccine, Long> {


    @Query("SELECT v FROM Vaccine v WHERE v.animal.id = :animalId AND v.code = :vaccineCode AND v.protectionFinishDate > CURRENT_DATE")
    Optional<Vaccine> findViableVaccineByAnimalIdAndCode(@Param("animalId") Long animalId, @Param("vaccineCode") String vaccineCode);


    List<Vaccine> findByAnimalId(Long animalId);


    @Query("SELECT v FROM Vaccine v WHERE v.protectionFinishDate BETWEEN :startDate AND :endDate")
    List<Vaccine> findVaccinesByProtectionEndDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}