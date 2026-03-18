package com.example.plataforma_lealtad_spring_azure.dtos.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginDTO {
    @NotBlank(message = "El email es requerido")
    @Email(message = "El formato de email no es valido")
    private String email;

    @NotBlank(message = "La password es requerida")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
