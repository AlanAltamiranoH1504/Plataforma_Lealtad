package com.example.plataforma_lealtad_spring_azure.services;

import com.example.plataforma_lealtad_spring_azure.dtos.ListEntityDTO;
import com.example.plataforma_lealtad_spring_azure.dtos.rol.CreateRolDTO;
import com.example.plataforma_lealtad_spring_azure.exceptions.rol.RolExistsException;
import com.example.plataforma_lealtad_spring_azure.models.Rol;
import com.example.plataforma_lealtad_spring_azure.repositories.IRolRespitory;
import com.example.plataforma_lealtad_spring_azure.services.interfaces.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService implements IRolService {
    @Autowired
    private IRolRespitory iRolRespitory;

    @Override
    public List<Rol> listRols(ListEntityDTO listEntityDTO) {
        return List.of();
    }

    @Override
    public Rol getRol(Long idRol) {
        return null;
    }

    @Override
    public Rol saveRol(CreateRolDTO createRolDTO) {
        // * Validated NameRol
        Rol rolExists = iRolRespitory.findByNameRol(createRolDTO.getNameRol());
        if (rolExists != null) {
            throw new RolExistsException("El nombre del rol ya se encuentra registrado");
        }
        Rol rolToSave = new Rol(createRolDTO.getNameRol(), 1);
        iRolRespitory.save(rolToSave);
        return rolToSave;
    }

    @Override
    public void deleteRol(Long idRol) {

    }

    @Override
    public void destroyRol(Long idRol) {

    }
}
