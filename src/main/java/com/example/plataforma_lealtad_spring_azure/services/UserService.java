package com.example.plataforma_lealtad_spring_azure.services;

import com.example.plataforma_lealtad_spring_azure.dtos.ListEntityDTO;
import com.example.plataforma_lealtad_spring_azure.models.Program;
import com.example.plataforma_lealtad_spring_azure.models.User;
import com.example.plataforma_lealtad_spring_azure.repositories.IUserRepository;
import com.example.plataforma_lealtad_spring_azure.services.interfaces.IUserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserSevice {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public List<User> listUser(ListEntityDTO listEntityDTO) {
        return List.of();
    }

    @Override
    public User getUser(Long idUser) {
        return null;
    }

    @Override
    public User saveUser() {
        return null;
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        Optional<User> user = Optional.ofNullable(iUserRepository.getUserByEmail(email));
        return user;
    }

    @Override
    public void deleteUser(Long idUser) {

    }

    @Override
    public void destroyUser(Long idUser) {

    }
}
