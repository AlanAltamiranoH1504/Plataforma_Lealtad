package com.example.plataforma_lealtad_spring_azure.services.interfaces;

import com.example.plataforma_lealtad_spring_azure.dtos.ListEntityDTO;
import com.example.plataforma_lealtad_spring_azure.models.Program;
import com.example.plataforma_lealtad_spring_azure.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserSevice {
    public List<User> listUser(ListEntityDTO listEntityDTO);
    public User getUser(Long idUser);
    public User saveUser();
    public Optional<User> getUserByEmail(String email);
    public void deleteUser(Long idUser);
    public void destroyUser(Long idUser);
}
