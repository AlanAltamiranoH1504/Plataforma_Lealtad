package com.example.plataforma_lealtad_spring_azure.exceptions;

public class UnAuthorizeException extends RuntimeException {
    public UnAuthorizeException(String message) {
        super(message);
    }
}
