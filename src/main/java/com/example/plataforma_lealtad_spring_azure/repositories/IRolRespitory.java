package com.example.plataforma_lealtad_spring_azure.repositories;

import com.example.plataforma_lealtad_spring_azure.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IRolRespitory extends JpaRepository<Rol, Long> {
    @Query("SELECT r FROM Rol r WHERE r.name_rol = :nameRol")
    public Rol findByNameRol(@Param("nameRol") String nameRol);


}
