package com.vetapp.vetapp.controller;

import com.vetapp.vetapp.dto.request.AddAnimalRequest;
import com.vetapp.vetapp.dto.request.AddDatesRequest;
import com.vetapp.vetapp.entity.Animal;
import com.vetapp.vetapp.entity.Doctor;
import com.vetapp.vetapp.service.impl.AnimalServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/animals")
@RequiredArgsConstructor
public class AnimalController {

    private final AnimalServiceImpl animalService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Animal> findAll() {
        return animalService.findAll();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Animal getById(@PathVariable("id") Long id) {
        return animalService.getById(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<Animal> getAnimalsByCustomerId(@PathVariable Long customerId) {
        return animalService.findByCustomerId(customerId);
    }

    /*@PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Animal save(@RequestBody Animal animal) {
        return animalService.create(animal);
    }//çalışan kod*/

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Animal> save(@RequestBody AddAnimalRequest request) {
        Animal addedAnimal = animalService.create(
                request.getCustomerid(),
                request.getName(),
                request.getBreed(),
                request.getSpecies(),
                request.getColor(),
                request.getDateOfBirth());
        return ResponseEntity.ok(addedAnimal);
    }



    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Animal update(@PathVariable Long id, @RequestBody Animal newAnimal) {
        return animalService.update(id, newAnimal);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        animalService.deleteById(id);
    }

    /*@GetMapping("/findByAnimalName/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Animal findByName(@PathVariable("name") String name) {
        return animalService.findByName(name);
    }*/

    @GetMapping("/animalsname/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Animal> findByName(@PathVariable String name) {
        return animalService.findByName(name);
    }

    @GetMapping("/findByCustomerName/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Animal> findByCustomerName(@PathVariable("name") String name) {
        return animalService.findByCustomerName(name);
    }


}
