package com.farhan.crud.auth.service;

import com.farhan.crud.auth.dto.LoginRequest;
import com.farhan.crud.auth.dto.RegisterRequest;
import com.farhan.crud.entity.Role;
import com.farhan.crud.entity.User;
import com.farhan.crud.repository.UserRepository;
import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class AuthService {

    @Inject
    UserRepository repository;

    @Transactional
    public User register(RegisterRequest request) {

        if (repository.findByEmail(request.email).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();

        user.name = request.name;
        user.email = request.email;
        user.password = BcryptUtil.bcryptHash(request.password);
        user.age = request.age;
        user.role = Role.USER;

        repository.persist(user);

        return user;
    }

    public User login(LoginRequest request) {

        User user = repository.findByEmail(request.email)
                .orElseThrow(() -> new RuntimeException("Email atau password salah"));

        if (!BcryptUtil.matches(request.password, user.password)) {
            throw new RuntimeException("Email atau password salah");
        }

        return user;
    }
}