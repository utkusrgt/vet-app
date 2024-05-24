package com.vetapp.vetapp.controller;

import com.vetapp.vetapp.entity.AvailableDate;
import com.vetapp.vetapp.service.AvailableDateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/available-dates")
@RequiredArgsConstructor
public class AvailableDateController {

    private final AvailableDateService availableDateService;

    /*@PostMapping
    public ResponseEntity<AvailableDate> cre(@RequestBody AvailableDate availableDate) {
        AvailableDate createdDate = availableDateService.create(availableDate);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDate);
    }*/

}
