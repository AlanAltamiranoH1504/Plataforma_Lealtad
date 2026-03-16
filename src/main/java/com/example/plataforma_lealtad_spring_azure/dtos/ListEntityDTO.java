package com.example.plataforma_lealtad_spring_azure.dtos;

import jakarta.validation.constraints.NotEmpty;

public class ListEntityDTO {
    @NotEmpty(message = "El estado de listado es necesario true/false")
    public Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
