package com.vetapp.vetapp.dto.request;

import com.vetapp.vetapp.entity.Customer;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddAnimalRequest {

    private Long customerid;
    private String name;
    private String species;
    private String breed;
    private String color;
    private LocalDate dateOfBirth;

}
