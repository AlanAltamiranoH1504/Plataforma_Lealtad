package com.example.plataforma_lealtad_spring_azure.controllers;

import com.example.plataforma_lealtad_spring_azure.dtos.program.CreateProgramDTO;
import com.example.plataforma_lealtad_spring_azure.services.interfaces.IProgramService;
import com.example.plataforma_lealtad_spring_azure.services.interfaces.IResponseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/program")
public class ProgramController {
    @Autowired
    private IProgramService iProgramService;
    @Autowired
    private IResponseService iResponseService;

    @PostMapping("")
    public ResponseEntity<?> saveProgram(@Valid @RequestBody CreateProgramDTO createProgramDTO) {
        iProgramService.saveProgram(createProgramDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(
              iResponseService.generateResponse(true, "AAH001")
        );
    }
}
