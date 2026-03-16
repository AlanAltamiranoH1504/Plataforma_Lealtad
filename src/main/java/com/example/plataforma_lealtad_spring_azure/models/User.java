package com.example.plataforma_lealtad_spring_azure.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity()
@Table(name = "tbl_users")
@JsonPropertyOrder({"id_user", "email", "username", "password", "status", "program"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    private String email;
    private String username;
    private String password;
    private int status;
    @ManyToOne(fetch = FetchType.LAZY) // * Un usuario pertence a un programa
    @JoinColumn(name = "id_program")
    private Program program;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) // * Un usuario puede tener muchos roles
    @JoinTable(
            name = "tbl_rel_users_rols",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_rol")
    )
    private List<Rol> rols = new ArrayList<>();

    public User() {
    }

    public User(String email, String username, String password, int status, Program program, List<Rol> rols) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.status = status;
        this.program = program;
        this.rols = rols;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

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

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Rol> getRols() {
        return rols;
    }

    public void setRols(List<Rol> rols) {
        this.rols = rols;
    }
}
