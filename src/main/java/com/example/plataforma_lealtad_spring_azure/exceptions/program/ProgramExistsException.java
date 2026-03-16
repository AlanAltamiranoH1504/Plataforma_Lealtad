package com.example.plataforma_lealtad_spring_azure.exceptions.program;

public class ProgramExistsException extends RuntimeException {
    public ProgramExistsException(String message) {
        super(message);
    }
}
