package com.vetapp.vetapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "species", nullable = false)
    private String species;

    @Column(name = "breed", nullable = false)
    private String breed;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "animal")
    @JsonIgnore
    private Set<Vaccine> vaccines;

    @OneToMany(mappedBy = "animal")
    @JsonIgnore
    private Set<Appointment> appointments;
}
