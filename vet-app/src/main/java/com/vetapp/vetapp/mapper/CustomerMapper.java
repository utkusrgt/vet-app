package com.vetapp.vetapp.mapper;

import com.vetapp.vetapp.dto.request.CustomerRequest;
import com.vetapp.vetapp.dto.response.CustomerResponse;
import com.vetapp.vetapp.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface CustomerMapper {


    Customer asEntity(CustomerRequest customerRequest);

    CustomerResponse asOutput(Customer customer);

    List<CustomerResponse> asOutput(List<Customer> customer);

    void update(@MappingTarget Customer entity, CustomerRequest request);

}
