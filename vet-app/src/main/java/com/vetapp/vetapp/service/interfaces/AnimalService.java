package com.vetapp.vetapp.service.interfaces;

import com.vetapp.vetapp.entity.Animal;

import java.time.LocalDate;
import java.util.List;

public interface AnimalService {

    List<Animal> findAll();
    Animal getById(Long id);
    //Animal findByName(String name);
    List<Animal> findByCustomerName(String name);
    //Animal create(Animal animal); //çalışan kod
    public Animal create(Long customerId, String name, String breed, String species, String color, LocalDate dateOfBirth);
    Animal update(Long id, Animal animal);
    void deleteById(Long id);
    List<Animal> findByCustomerId(Long id);

    List<Animal> findByName(String name);
}
