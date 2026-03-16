package com.example.plataforma_lealtad_spring_azure.models;

import jakarta.persistence.*;

import java.util.List;

@Entity()
@Table(name = "tbl_programs")
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_program;
    private String name_program;
    private String primary_color;
    private String secondary_color;
    private int status;
    @OneToMany(mappedBy = "program") // * Un programa tiene n usuarios
    private List<User> users;

    public Program() {
    }

    public Program(String name_program, String primary_color, String secondary_color, int status) {
        this.name_program = name_program;
        this.primary_color = primary_color;
        this.secondary_color = secondary_color;
        this.status = status;
    }

    public Long getId_program() {
        return id_program;
    }

    public void setId_program(Long id_program) {
        this.id_program = id_program;
    }

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
