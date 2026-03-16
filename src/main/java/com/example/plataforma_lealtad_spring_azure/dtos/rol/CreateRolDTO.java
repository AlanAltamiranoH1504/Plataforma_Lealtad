package com.example.plataforma_lealtad_spring_azure.dtos.rol;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class CreateRolDTO {
    @NotBlank(message = "El nombre del rol es requerido")
    @Length(max = 100, message = "El nombre del rol no puede ser mayor a 100 caracteres")
    private String nameRol;

    public String getNameRol() {
        return nameRol;
    }

    public void setNameRol(String nameRol) {
        this.nameRol = nameRol;
    }
}
