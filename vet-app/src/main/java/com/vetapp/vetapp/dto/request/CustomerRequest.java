package com.vetapp.vetapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerRequest{

    private String name;
    private String phone;
    private String mail;
    private String address;
    private String city;
}
