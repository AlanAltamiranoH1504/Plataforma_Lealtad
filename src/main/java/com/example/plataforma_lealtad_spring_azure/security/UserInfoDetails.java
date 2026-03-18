package com.example.plataforma_lealtad_spring_azure.security;

import com.example.plataforma_lealtad_spring_azure.models.User;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserInfoDetails implements UserDetails {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private Long idUser;
    private List<GrantedAuthority> authorities;

    public UserInfoDetails(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.idUser = user.getId_user();
        this.authorities = user.getRols().stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getName_rol()))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public @Nullable String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public Long getIdUser() {
        return this.idUser;
    }
}
