package com.example.plataforma_lealtad_spring_azure.models;

import jakarta.persistence.*;

@Entity()
@Table(name = "tbl_administrators")
public class Administrator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_admin;
    private String name_admin;
    private String lastname_admin;
    private String token_reset_password;
    private String randome_number;
    private int status;
    @OneToOne()
    @JoinColumn(name = "id_user")
    private User user;

    public Administrator() {
    }

    public Administrator(String name_admin, String lastname_admin, String token_reset_password, String randome_number, int status, User user) {
        this.name_admin = name_admin;
        this.lastname_admin = lastname_admin;
        this.token_reset_password = token_reset_password;
        this.randome_number = randome_number;
        this.status = status;
        this.user = user;
    }

    public Long getId_admin() {
        return id_admin;
    }

    public void setId_admin(Long id_admin) {
        this.id_admin = id_admin;
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

    public String getToken_reset_password() {
        return token_reset_password;
    }

    public void setToken_reset_password(String token_reset_password) {
        this.token_reset_password = token_reset_password;
    }

    public String getRandome_number() {
        return randome_number;
    }

    public void setRandome_number(String randome_number) {
        this.randome_number = randome_number;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
