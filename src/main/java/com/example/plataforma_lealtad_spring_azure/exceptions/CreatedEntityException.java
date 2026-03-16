package com.example.plataforma_lealtad_spring_azure.exceptions;

public class CreatedEntityException extends RuntimeException {
    public CreatedEntityException(String message) {
        super(message);
    }
}
