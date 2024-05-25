package com.vetapp.vetapp.controller;

import com.vetapp.vetapp.service.impl.AvailableDateServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/available-dates")
@RequiredArgsConstructor
public class AvailableDateController {

    private final AvailableDateServiceImpl availableDateService;

    /*@PostMapping
    public ResponseEntity<AvailableDate> cre(@RequestBody AvailableDate availableDate) {
        AvailableDate createdDate = availableDateService.create(availableDate);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDate);
    }*/

}
