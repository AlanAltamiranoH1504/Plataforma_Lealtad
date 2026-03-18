package com.example.plataforma_lealtad_spring_azure.security;

import com.example.plataforma_lealtad_spring_azure.models.User;
import com.example.plataforma_lealtad_spring_azure.services.interfaces.IUserSevice;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private IUserSevice iUserSevice;
    @Autowired
    private JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String headerAuth = request.getHeader("Authorization");
        String token = null;
        String email = null;
        Long idUser = null;

        // * Validacion existencia de token y no corrupto
        if (headerAuth != null && headerAuth.startsWith("Bearer ")) {
            token = headerAuth.substring(7);
            email = jwtService.extracMail(token);
            idUser = jwtService.extractIdUser(token);
        }

        // * Validacion de email en claims
        if (email != null && idUser != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            Optional<User> user = iUserSevice.getUserByEmail(email);
            if (jwtService.isValidToken(token, user.get())) {
                var authorities = user.get().getRols().stream()
                        .map(rol -> new SimpleGrantedAuthority(rol.getName_rol()))
                        .toList();
                UserInfoDetails userInfoDetails = new UserInfoDetails(user.get());
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, userInfoDetails, authorities);
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(request,response);
    }
}
