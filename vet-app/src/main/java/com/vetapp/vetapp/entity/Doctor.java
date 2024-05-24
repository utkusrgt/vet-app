package com.vetapp.vetapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "mail", nullable = false)
    private String mail;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "city", nullable = false)
    private String city;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private Set<Appointment> appointments;

    @ManyToMany(fetch = FetchType.EAGER)

    @JoinTable(
            name = "available_dates_doctors",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "available_date_id")
    )
    private List<AvailableDate> availableDates;

    public Doctor(Long id, String name, String phone, String mail, String address, String city,Set<Appointment> appointments) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.address = address;
        this.city = city;
        this.appointments = appointments;

    }

}
