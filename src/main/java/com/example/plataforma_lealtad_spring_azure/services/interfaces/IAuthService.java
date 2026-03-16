package com.example.plataforma_lealtad_spring_azure.services.interfaces;

import com.example.plataforma_lealtad_spring_azure.dtos.auth.CreateCustomerAccountDTO;

public interface IAuthService {
    public abstract void createAccountCustomer(CreateCustomerAccountDTO createCustomerAccountDTO);
}
