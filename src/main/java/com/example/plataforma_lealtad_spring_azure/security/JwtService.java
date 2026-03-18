package com.example.plataforma_lealtad_spring_azure.security;

import com.example.plataforma_lealtad_spring_azure.models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtService {
    @Value("${JWT_SECRET}")
    private String JWT_SECRET;

    // * Generacion de token con claims
    public String generateTokenJWT(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("rols", user.getRols().stream()
                .map(rol -> rol.getName_rol())
                .toList());
        return createToken(claims, user.getEmail(), user.getId_user());
    }

    // * Generacion de token
    public String createToken(Map<String, Object> claims, String email, Long idUser) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setId(String.valueOf(idUser))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 10000 * 6000 * 30))
                .signWith(getSignKey(), SignatureAlgorithm.HS512).compact();
    }

    // * Firma del token
    protected Key getSignKey() {
        byte [] keyBytes = Decoders.BASE64.decode(this.JWT_SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // * Obtencion de todos los claims
    protected Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // * Obtencion de claims de token
    protected <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // * Obtencion de email de token
    protected String extracMail(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // * Obtencion de id de usuario
    protected Long extractIdUser(String token) {
        return Long.valueOf(extractClaim(token, Claims::getId));
    }

    // * Obtencion de roles del tolen
    protected List<String> extractRoles(String token) {
        return extractClaim(token, claims -> claims.get("rols", List.class));
    }

    // * Obtencion de fecha de expiracion
    protected Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // * Verificacion token expirado
    protected boolean isExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // * Validacion de token
    public boolean isValidToken(String token, User user) {
        final String email = extracMail(token);
        return (email.equals(user.getEmail())) && !isExpired(token);
    }

}
