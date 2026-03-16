package com.example.plataforma_lealtad_spring_azure.exceptions.rol;

public class RolExistsException extends RuntimeException {
    public RolExistsException(String message) {
        super(message);
    }
}
