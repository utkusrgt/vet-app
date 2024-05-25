package com.vetapp.vetapp.service.interfaces;

import com.vetapp.vetapp.entity.Animal;

import java.util.List;

public interface AnimalService {

    List<Animal> findAll();
    Animal getById(Long id);
    Animal findByName(String name);
    List<Animal> findByCustomerName(String name);
    Animal create(Animal animal);
    Animal update(Long id, Animal animal);
    void deleteById(Long id);
    List<Animal> findByCustomerId(Long id);
}
