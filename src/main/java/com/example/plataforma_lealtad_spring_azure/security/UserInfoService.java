package com.example.plataforma_lealtad_spring_azure.security;

import com.example.plataforma_lealtad_spring_azure.models.User;
import com.example.plataforma_lealtad_spring_azure.services.interfaces.IUserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoService implements UserDetailsService {
    @Autowired
    private IUserSevice iUserSevice;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = iUserSevice.getUserByEmail(email);

        return user.map(UserInfoDetails::new).orElseThrow(() -> new UsernameNotFoundException("Usuario con email " + email + "no encontrado"));
    }
}
