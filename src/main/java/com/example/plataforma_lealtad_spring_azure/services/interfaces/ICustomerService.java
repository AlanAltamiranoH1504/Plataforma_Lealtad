package com.example.plataforma_lealtad_spring_azure.services.interfaces;

import com.example.plataforma_lealtad_spring_azure.dtos.ListEntityDTO;
import com.example.plataforma_lealtad_spring_azure.dtos.auth.CreateCustomerAccountDTO;
import com.example.plataforma_lealtad_spring_azure.models.Customer;

import java.util.List;

public interface ICustomerService {
    public abstract List<Customer> findAllCustomers(ListEntityDTO listEntityDTO);
    public abstract Customer findCustomerById(Long idCustomer);
    public abstract Customer saveCustomer(CreateCustomerAccountDTO createCustomerAccountDTO);
    public abstract void deleteCustomerById(Long idCustomer);
    public abstract void destroyCustomer(Long idCustomer);
}
