package com.example.plataforma_lealtad_spring_azure.services;

import com.example.plataforma_lealtad_spring_azure.dtos.ListEntityDTO;
import com.example.plataforma_lealtad_spring_azure.models.Program;
import com.example.plataforma_lealtad_spring_azure.models.User;
import com.example.plataforma_lealtad_spring_azure.services.interfaces.IUserSevice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserSevice {
    @Override
    public List<User> listUser(ListEntityDTO listEntityDTO) {
        return List.of();
    }

    @Override
    public Program getUser(Long idUser) {
        return null;
    }

    @Override
    public Program saveUser() {
        return null;
    }

    @Override
    public void deleteUser(Long idUser) {

    }

    @Override
    public void destroyUser(Long idUser) {

    }
}
