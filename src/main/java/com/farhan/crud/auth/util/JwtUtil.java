package com.farhan.crud.auth.util;

import com.farhan.crud.entity.User;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.Duration;

@ApplicationScoped
public class JwtUtil {

    public String generateToken(User user) {

        return Jwt.issuer("quarkus-crud")
                .subject(user.email)
                .groups(user.role.name())
                .claim("userId", user.id)
                .claim("name", user.name)
                .expiresIn(Duration.ofHours(2))
                .sign();

    }

}