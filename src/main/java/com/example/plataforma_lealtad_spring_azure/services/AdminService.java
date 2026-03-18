package com.example.plataforma_lealtad_spring_azure.services;

import com.example.plataforma_lealtad_spring_azure.dtos.ListEntityDTO;
import com.example.plataforma_lealtad_spring_azure.dtos.auth.CreateAdminAccountDTO;
import com.example.plataforma_lealtad_spring_azure.models.Administrator;
import com.example.plataforma_lealtad_spring_azure.repositories.IAdminRepository;
import com.example.plataforma_lealtad_spring_azure.services.interfaces.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements IAdminService {
    @Autowired
    private IAdminRepository iAdminRepository;

    @Override
    public List<Administrator> findAll(ListEntityDTO listEntityDTO) {
        return List.of();
    }

    @Override
    public Administrator findById(Long idAdmin) {
        return null;
    }

    @Override
    public Administrator save(CreateAdminAccountDTO createAdminAccountDTO) {
        return null;
    }

    @Override
    public void deleteById(Long idAdmin) {

    }

    @Override
    public void destroy(Long idAdmin) {

    }
}
