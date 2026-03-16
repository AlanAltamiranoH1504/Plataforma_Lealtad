package com.example.plataforma_lealtad_spring_azure.dtos.auth;

import com.example.plataforma_lealtad_spring_azure.models.Program;
import com.example.plataforma_lealtad_spring_azure.models.Rol;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public class CreateCustomerAccountDTO {
    // * Tbl_User
    @NotBlank(message = "El email de cliente es requerido")
    @Length(max = 100, message = "El email no puede tener mas de 100 caracteres")
    @Email(message = "Formato de email no valido")
    private String email;

    @NotBlank(message = "El username es requerido")
    @Length(max = 100, message = "El username no puede tener mas de 100 caracteres")
    private String username;

    @NotBlank(message = "El password es requerido")
    @Length(max = 250, message = "Contraseña no valida")
    private String password;

    @NotNull(message = "El programa de pertenencia es requerido")
    @Positive(message = "El programa no es valido")
    private Long program;

    @NotEmpty(message = "Los roles son requeridos")
    private List<
            @Positive(message = "El id del rol no es valido")
                    Long> rols;

    // * Tbl_Customer
    @NotBlank(message = "El nombre del cliente es requerido")
    @Length(max = 150, message = "El nombre del cliente no puede ser mayor a 150 caracteres")
    private String name_customer;

    @NotBlank(message = "Los apellidos son requeridos")
    @Length(max = 200, message = "Los apellidos no pueden ser mayor a 200 caracteres")
    private String lastname_customer;

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

    public List<

            Long> getRols() {
        return rols;
    }

    public void setRols(List<

            Long> rols) {
        this.rols = rols;
    }

    public String getName_customer() {
        return name_customer;
    }

    public void setName_customer(String name_customer) {
        this.name_customer = name_customer;
    }

    public String getLastname_customer() {
        return lastname_customer;
    }

    public void setLastname_customer(String lastname_customer) {
        this.lastname_customer = lastname_customer;
    }
}
