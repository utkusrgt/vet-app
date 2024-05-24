package com.vetapp.vetapp.controller;

import com.vetapp.vetapp.dto.request.CustomerRequest;
import com.vetapp.vetapp.dto.response.CustomerResponse;
import com.vetapp.vetapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponse> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse getById(@PathVariable("id") Long id) {
        return customerService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse save(@RequestBody CustomerRequest customer) {
        return customerService.create(customer);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse update(@PathVariable Long id, @RequestBody CustomerRequest request) {
        return customerService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        customerService.deleteById(id);
    }

    @GetMapping("/findByName/{name}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse findByName(@PathVariable("name") String name) {
        return customerService.findByName(name);
    }


}
