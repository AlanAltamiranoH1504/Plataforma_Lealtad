package com.example.plataforma_lealtad_spring_azure.services.interfaces;

import com.example.plataforma_lealtad_spring_azure.dtos.ListEntityDTO;
import com.example.plataforma_lealtad_spring_azure.dtos.program.CreateProgramDTO;
import com.example.plataforma_lealtad_spring_azure.models.Program;

import java.util.List;

public interface IProgramService {
    public List<Program> listPrograms(ListEntityDTO listEntityDTO);
    public Program getProgram(Long idProgram);
    public Program saveProgram(CreateProgramDTO createProgramDTO);
    public void deleteProgram(Long idProgram);
    public void destroyProgram(Long idProgram);
}
