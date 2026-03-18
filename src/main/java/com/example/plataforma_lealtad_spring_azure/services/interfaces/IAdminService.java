package com.example.plataforma_lealtad_spring_azure.services.interfaces;

import com.example.plataforma_lealtad_spring_azure.dtos.ListEntityDTO;
import com.example.plataforma_lealtad_spring_azure.dtos.auth.CreateAdminAccountDTO;
import com.example.plataforma_lealtad_spring_azure.models.Administrator;

import java.util.List;

public interface IAdminService {
    public abstract List<Administrator> findAll(ListEntityDTO listEntityDTO);
    public abstract Administrator findById(Long idAdmin);
    public abstract Administrator save(CreateAdminAccountDTO createAdminAccountDTO);
    public abstract void deleteById(Long idAdmin);
    public abstract void destroy(Long idAdmin);
}
