package com.example.plataforma_lealtad_spring_azure.services.interfaces;

import com.example.plataforma_lealtad_spring_azure.dtos.auth.CreateAdminAccountDTO;
import com.example.plataforma_lealtad_spring_azure.dtos.auth.CreateCustomerAccountDTO;
import com.example.plataforma_lealtad_spring_azure.dtos.auth.LoginDTO;

public interface IAuthService {
    public abstract void createAccountCustomer(CreateCustomerAccountDTO createCustomerAccountDTO);
    public abstract void createAccountAdmin(CreateAdminAccountDTO createAdminAccountDTO);
    public abstract String login(LoginDTO loginDTO);
    public abstract boolean isEmailInUse(String email);
    public abstract boolean isCorrectRol(Long idRol);
    public abstract boolean isProgramValid(Long idProgram);
}
