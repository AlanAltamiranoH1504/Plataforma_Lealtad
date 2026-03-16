package com.example.plataforma_lealtad_spring_azure.dtos.program;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class CreateProgramDTO {
    @NotBlank(message = "El nombre del programa es requerido")
    @Length(max = 200, message = "El nombre no puede ser mayor a 200 caracteres")
    private String name_program;

    @NotBlank(message = "El color primario es requerido")
    @Length(max = 45, message = "El color primario no puede ser mayor a 45 caracteres")
    private String primary_color;

    @NotBlank(message = "El color secundario es requerido")
    @Length(max = 45, message = "El color secundario no puede ser mayor a 45 caracteres")
    private String secondary_color;

    public String getName_program() {
        return name_program;
    }

    public void setName_program(String name_program) {
        this.name_program = name_program;
    }

    public String getPrimary_color() {
        return primary_color;
    }

    public void setPrimary_color(String primary_color) {
        this.primary_color = primary_color;
    }

    public String getSecondary_color() {
        return secondary_color;
    }

    public void setSecondary_color(String secondary_color) {
        this.secondary_color = secondary_color;
    }
}
