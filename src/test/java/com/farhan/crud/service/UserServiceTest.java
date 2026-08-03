package com.farhan.crud.service;

import com.farhan.crud.dto.CreateUserRequest;
import com.farhan.crud.entity.User;
import com.farhan.crud.repository.UserRepository;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class UserServiceTest {

    @Inject
    UserService service;

    @Inject
    UserRepository repository;

    @BeforeEach
    @Transactional
    void setup() {
        repository.deleteAll();
    }

    @Test
    void shouldCreateUser() {

        CreateUserRequest request = new CreateUserRequest();

        request.name = "JUnit";
        request.email = UUID.randomUUID() + "@test.com";
        request.age = 20;

        User user = service.create(request);

        assertNotNull(user);
        assertNotNull(user.id);
        assertEquals("JUnit", user.name);
        assertEquals(request.email, user.email);
    }

    @Test
    void shouldThrowExceptionWhenEmailAlreadyExists() {

        CreateUserRequest request = new CreateUserRequest();

        request.name = "JUnit";
        request.email = UUID.randomUUID() + "@test.com";
        request.age = 20;

        service.create(request);

        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> service.create(request)
        );

        assertEquals("Email already exists", exception.getMessage());
    }

}