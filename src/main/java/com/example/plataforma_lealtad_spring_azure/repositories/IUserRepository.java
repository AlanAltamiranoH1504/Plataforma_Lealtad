package com.example.plataforma_lealtad_spring_azure.repositories;

import com.example.plataforma_lealtad_spring_azure.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
