package com.vetapp.vetapp.service.interfaces;

import com.vetapp.vetapp.dto.request.CustomerRequest;
import com.vetapp.vetapp.dto.response.CustomerResponse;

import java.util.List;

public interface CustomerService {

    List<CustomerResponse> findAll();
    CustomerResponse getById(Long id);
    CustomerResponse findByName(String name);
    CustomerResponse create(CustomerRequest request);
    CustomerResponse update(Long id, CustomerRequest request);
    void deleteById(Long id);
}
