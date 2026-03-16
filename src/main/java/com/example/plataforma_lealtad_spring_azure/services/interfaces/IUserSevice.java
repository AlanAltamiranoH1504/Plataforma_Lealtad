package com.example.plataforma_lealtad_spring_azure.services.interfaces;

import com.example.plataforma_lealtad_spring_azure.dtos.ListEntityDTO;
import com.example.plataforma_lealtad_spring_azure.models.Program;
import com.example.plataforma_lealtad_spring_azure.models.User;

import java.util.List;

public interface IUserSevice {
    public List<User> listUser(ListEntityDTO listEntityDTO);
    public Program getUser(Long idUser);
    public Program saveUser();
    public void deleteUser(Long idUser);
    public void destroyUser(Long idUser);
}
