package com.example.plataforma_lealtad_spring_azure.exceptions.user;

public class EmailInUseException extends RuntimeException {
    public EmailInUseException(String message) {
        super(message);
    }
}
