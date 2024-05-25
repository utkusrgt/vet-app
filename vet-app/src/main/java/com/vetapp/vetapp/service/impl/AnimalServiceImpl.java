package com.vetapp.vetapp.service.impl;

import com.vetapp.vetapp.entity.Animal;
import com.vetapp.vetapp.repository.AnimalRepository;
import com.vetapp.vetapp.service.interfaces.AnimalService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;

    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    public Animal getById(Long id) {
        return animalRepository.findById(id).orElseThrow(() -> new RuntimeException(id + " animal could not found !!!"));
    }

    public Animal findByName(String name) {
        return (Animal) animalRepository.findByName(name).orElseThrow(() -> new RuntimeException(" animal could not found !!!"));

    }

    public List<Animal> findByCustomerName(String name) {
        return animalRepository.findByCustomerName(name);
    }



    @Transactional
    public Animal create(Animal animal) {
        Optional<Animal> isAnimalExist = animalRepository.findByNameAndCustomer(animal.getName(), animal.getCustomer());

        if (isAnimalExist.isEmpty()) {
            return this.animalRepository.save(animal);
        }
        throw new RuntimeException("This animal is already exists !!!");
    }

    public Animal update(Long id, Animal animal) {

        Optional<Animal> animalFromDb = animalRepository.findById(id);

        if (animalFromDb.isEmpty()) {
            throw new RuntimeException(id + " animal could not found !!!.");
        }

        animal.setId(id);
        return this.animalRepository.save(animal);
    }

    public void deleteById(Long id) {
        Optional<Animal> animalFromDb = animalRepository.findById(id);
        if (animalFromDb.isPresent()) {
            animalRepository.delete(animalFromDb.get());
        } else {
            throw new RuntimeException(id + " animal could not found !!!");
        }
    }

    public List<Animal> findByCustomerId(Long id) {
        return animalRepository.findByCustomerId(id);
    }




}
