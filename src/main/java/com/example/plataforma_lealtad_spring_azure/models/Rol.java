package com.example.plataforma_lealtad_spring_azure.models;

import jakarta.persistence.*;

import java.util.List;

@Entity()
@Table(name = "tbl_rols")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name_rol;
    private int status;
    @ManyToMany(mappedBy = "rols") // * Un rol puede pertencer a varios usuarios
    private List<User> users;

    public Rol() {
    }

    public Rol(String name_rol, int status) {
        this.name_rol = name_rol;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_rol() {
        return name_rol;
    }

    public void setName_rol(String name_rol) {
        this.name_rol = name_rol;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
