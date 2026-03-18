package com.example.plataforma_lealtad_spring_azure.repositories;

import com.example.plataforma_lealtad_spring_azure.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = :email")
    public abstract User getUserByEmail(@Param("email") String email);

    List<User> findUserByEmail(String email);
}
