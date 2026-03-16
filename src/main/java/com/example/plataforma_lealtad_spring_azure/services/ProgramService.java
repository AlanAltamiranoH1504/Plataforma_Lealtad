package com.example.plataforma_lealtad_spring_azure.services;

import com.example.plataforma_lealtad_spring_azure.dtos.ListEntityDTO;
import com.example.plataforma_lealtad_spring_azure.dtos.program.CreateProgramDTO;
import com.example.plataforma_lealtad_spring_azure.exceptions.CreatedEntityException;
import com.example.plataforma_lealtad_spring_azure.exceptions.program.ProgramExistsException;
import com.example.plataforma_lealtad_spring_azure.models.Program;
import com.example.plataforma_lealtad_spring_azure.repositories.IProgramRepository;
import com.example.plataforma_lealtad_spring_azure.services.interfaces.IProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramService implements IProgramService {
    @Autowired
    private IProgramRepository iProgramRepository;

    @Override
    public List<Program> listPrograms(ListEntityDTO listEntityDTO) {
        return List.of();
    }

    @Override
    public Program getProgram(Long idProgram) {
        return null;
    }

    @Override
    public Program saveProgram(CreateProgramDTO createProgramDTO) {
        // * Validated NameProgram
        Program programExists = iProgramRepository.findByName(createProgramDTO.getName_program());
        if (programExists != null) {
            throw new ProgramExistsException("El nombre del programa ya se encuentra registrado");
        }
        Program programToSave = new Program(createProgramDTO.getName_program(), createProgramDTO.getPrimary_color(), createProgramDTO.getSecondary_color());
        iProgramRepository.save(programToSave);
        if (programToSave.getId_program() == null) {
            throw new CreatedEntityException("Ocurrio un error en la creación del programa");
        }
        return programToSave;
    }

    @Override
    public void deleteProgram(Long idProgram) {

    }

    @Override
    public void destroyProgram(Long idProgram) {

    }
}
