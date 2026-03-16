package com.example.plataforma_lealtad_spring_azure.services.interfaces;

import com.example.plataforma_lealtad_spring_azure.dtos.ListEntityDTO;
import com.example.plataforma_lealtad_spring_azure.dtos.rol.CreateRolDTO;
import com.example.plataforma_lealtad_spring_azure.models.Program;
import com.example.plataforma_lealtad_spring_azure.models.Rol;

import java.util.List;

public interface IRolService {
    public List<Rol> listRols(ListEntityDTO listEntityDTO);
    public Rol getRol(Long idRol);
    public Rol saveRol(CreateRolDTO createRolDTO);
    public void deleteRol(Long idRol);
    public void destroyRol(Long idRol);
}
