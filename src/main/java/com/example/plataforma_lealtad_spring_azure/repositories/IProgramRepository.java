package com.example.plataforma_lealtad_spring_azure.repositories;

import com.example.plataforma_lealtad_spring_azure.models.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProgramRepository extends JpaRepository<Program, Long> {
    @Query("SELECT p FROM Program p WHERE p.name_program = :nameProgram")
    public abstract Program findByName(@Param("nameProgram") String nameProgram);
}
