package com.vetapp.vetapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "protection_start_date", nullable = false)
    private LocalDate protectionStartDate;

    @Column(name = "protection_finish_date", nullable = false)
    private LocalDate protectionFinishDate;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

}
