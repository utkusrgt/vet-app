package com.vetapp.vetapp.service;

import com.vetapp.vetapp.dto.request.CustomerRequest;
import com.vetapp.vetapp.dto.response.CustomerResponse;
import com.vetapp.vetapp.entity.Customer;
import com.vetapp.vetapp.mapper.CustomerMapper;
import com.vetapp.vetapp.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;



    public List<CustomerResponse> findAll() {
        return customerMapper.asOutput(customerRepository.findAll());
    }

    public CustomerResponse getById(Long id) {
        return customerMapper.asOutput(customerRepository.findById(id).orElseThrow(() -> new RuntimeException(id + " Customer could not found !!!")));
    }

    public CustomerResponse findByName(String name) {
        return customerMapper.asOutput((Customer) customerRepository.findByName(name).orElseThrow(() -> new RuntimeException(" Customer could not found !!!")));

    }


    public CustomerResponse create(CustomerRequest request) {
        Optional<Customer> isCustomerExist = customerRepository.findByNameAndPhoneAndMail(request.getName(), request.getPhone(), request.getMail());

        if (isCustomerExist.isEmpty()) {
            Customer customerSaved = customerRepository.save(customerMapper.asEntity(request));
            return customerMapper.asOutput(customerSaved);
        }
        throw new RuntimeException("This customer is already exists !!!");
    }

    public CustomerResponse update(Long id, CustomerRequest request) {

        Optional<Customer> customerFromDb = customerRepository.findById(id);

        Optional<Customer> isCustomerExist = customerRepository.findByNameAndPhoneAndMail(request.getName(), request.getPhone(), request.getMail());

        if (customerFromDb.isEmpty()) {
            throw new RuntimeException(id + "  Customer could not found !!!.");
        }

        if (isCustomerExist.isPresent()) {
            throw new RuntimeException(" This customer already exists !!!");
        }
        Customer customer = customerFromDb.get();
        customerMapper.update(customer, request);
        return customerMapper.asOutput(customerRepository.save(customer));
    }

    public void deleteById(Long id) {
        Optional<Customer> customerFromDb = customerRepository.findById(id);
        if (customerFromDb.isPresent()) {
            customerRepository.delete(customerFromDb.get());
        } else {
            throw new RuntimeException(id + " Customer could not found !!!");
        }
    }


}
