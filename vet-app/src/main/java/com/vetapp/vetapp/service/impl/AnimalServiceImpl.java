package com.vetapp.vetapp.service.impl;

import com.vetapp.vetapp.entity.Animal;
import com.vetapp.vetapp.entity.AvailableDate;
import com.vetapp.vetapp.entity.Customer;
import com.vetapp.vetapp.entity.Doctor;
import com.vetapp.vetapp.repository.AnimalRepository;
import com.vetapp.vetapp.repository.CustomerRepository;
import com.vetapp.vetapp.service.interfaces.AnimalService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;
    private final CustomerRepository customerRepository;

    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    public Animal getById(Long id) {
        return animalRepository.findById(id).orElseThrow(() -> new RuntimeException(id + " animal could not found !!!"));
    }

    /*public Animal findByName(String name) {
        return (Animal) animalRepository.findByName(name).orElseThrow(() -> new RuntimeException(" animal could not found !!!"));

    }*/

    public List<Animal> findByName(String name) {
        List<Animal> animals = animalRepository.findByName(name);
        if (animals.isEmpty()) {
            throw new RuntimeException("Animal could not be found!!!");
        }
        return animals;
    }


    public List<Animal> findByCustomerName(String name) {
        return animalRepository.findByCustomerName(name);
    }


    /*@Transactional
    public Animal create(Animal animal) {
        Optional<Animal> isAnimalExist = animalRepository.findByNameAndCustomer(animal.getName(), animal.getCustomer());

        if (isAnimalExist.isEmpty()) {
            return this.animalRepository.save(animal);
        }
        throw new RuntimeException("This animal is already exists !!!");
    }*/
    //Çalışan kod
        @Transactional
        public Animal create(Long customerId, String name, String breed, String species, String color, LocalDate dateOfBirth) {

            Customer customer = customerRepository.findById(customerId)
                    .orElseThrow(() -> new RuntimeException("Customer not found"));

            Animal animal = animalRepository.findByAnimalNameAndCustomerId(name, customerId);
            if (animal != null) {
                throw new RuntimeException("This animal is already exists !!!");
            }

            Animal newAnimal = new Animal();
            newAnimal.setCustomer(customer);
            newAnimal.setName(name);
            newAnimal.setBreed(breed);
            newAnimal.setSpecies(species);
            newAnimal.setColor(color);
            newAnimal.setDateOfBirth(dateOfBirth);

            return animalRepository.save(newAnimal);
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
