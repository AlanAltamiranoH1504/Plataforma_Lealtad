package com.example.plataforma_lealtad_spring_azure.services;

import com.example.plataforma_lealtad_spring_azure.dtos.ListEntityDTO;
import com.example.plataforma_lealtad_spring_azure.dtos.auth.CreateCustomerAccountDTO;
import com.example.plataforma_lealtad_spring_azure.models.Customer;
import com.example.plataforma_lealtad_spring_azure.services.interfaces.ICustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Override
    public List<Customer> findAllCustomers(ListEntityDTO listEntityDTO) {
        return List.of();
    }

    @Override
    public Customer findCustomerById(Long idCustomer) {
        return null;
    }

    @Override
    public Customer saveCustomer(CreateCustomerAccountDTO createCustomerAccountDTO) {
        return null;
    }

    @Override
    public void deleteCustomerById(Long idCustomer) {

    }

    @Override
    public void destroyCustomer(Long idCustomer) {

    }
}
