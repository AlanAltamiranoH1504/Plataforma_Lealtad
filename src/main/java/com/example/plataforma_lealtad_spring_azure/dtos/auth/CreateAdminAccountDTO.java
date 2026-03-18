package com.example.plataforma_lealtad_spring_azure.dtos.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public class CreateAdminAccountDTO {
    // * Tbl_Users
    @NotBlank(message = "El email es requerido")
    @Email(message = "Formato de email no valido")
    @Length(max = 100, message = "El mail maximo puede tener 100 caracteres")
    private String email;

    @NotBlank(message = "El username es requerido")
    @Length(max = 100, message = "El username puede tener maximo 100 caracteres")
    private String username;

    @NotBlank(message = "El password es requerido")
    @Length(max = 255, message = "Password no valida")
    private String password;

    @NotNull(message = "El programa es requerido")
    @Positive(message = "El id del programa no es valido")
    private Long program;

    @NotNull(message = "El rol es requerido")
    @Positive(message = "El id del rol no es valido")
    private Long rol;

    // * Tbl_Administrators
    @NotBlank(message = "El nombre es requerido")
    @Length(max = 100, message = "El nombre no puede tener mas de 100 caracteres")
    private String name_admin;
    @NotBlank(message = "Los apellidos son requeridos")
    @Length(max = 200, message = "Los apellidos no pueden tener mas de 200 caracteeres")
    private String lastname_admin;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getProgram() {
        return program;
    }

    public void setProgram(Long program) {
        this.program = program;
    }

    public Long getRol() {
        return rol;
    }

    public void setRol(Long rol) {
        this.rol = rol;
    }

    public String getName_admin() {
        return name_admin;
    }

    public void setName_admin(String name_admin) {
        this.name_admin = name_admin;
    }

    public String getLastname_admin() {
        return lastname_admin;
    }

    public void setLastname_admin(String lastname_admin) {
        this.lastname_admin = lastname_admin;
    }
}
