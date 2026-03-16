package com.example.plataforma_lealtad_spring_azure.models;

import jakarta.persistence.*;

@Entity()
@Table(name = "tbl_customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_customer;
    private String name_customer;
    private String lastname_customer;
    private double accumulated_points;
    private double points_redeemed;
    private String address;
    private String img_profile;
    private String token_confirm_account;
    private String token_reset_password;
    private String randome_number;
    private int status;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private User user;

    public Customer() {
    }

    public Customer(String name_customer, String lastname_customer, double accumulated_points, double points_redeemed, String address, String img_profile, String token_confirm_account, String token_reset_password, String randome_number, int status, User user) {
        this.name_customer = name_customer;
        this.lastname_customer = lastname_customer;
        this.accumulated_points = accumulated_points;
        this.points_redeemed = points_redeemed;
        this.address = address;
        this.img_profile = img_profile;
        this.token_confirm_account = token_confirm_account;
        this.token_reset_password = token_reset_password;
        this.randome_number = randome_number;
        this.status = status;
        this.user = user;
    }

    public Long getId_customer() {
        return id_customer;
    }

    public void setId_customer(Long id_customer) {
        this.id_customer = id_customer;
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

    public double getAccumulated_points() {
        return accumulated_points;
    }

    public void setAccumulated_points(double accumulated_points) {
        this.accumulated_points = accumulated_points;
    }

    public double getPoints_redeemed() {
        return points_redeemed;
    }

    public void setPoints_redeemed(double points_redeemed) {
        this.points_redeemed = points_redeemed;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImg_profile() {
        return img_profile;
    }

    public void setImg_profile(String img_profile) {
        this.img_profile = img_profile;
    }

    public String getToken_confirm_account() {
        return token_confirm_account;
    }

    public void setToken_confirm_account(String token_confirm_account) {
        this.token_confirm_account = token_confirm_account;
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
