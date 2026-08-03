package com.farhan.crud.service;

import com.farhan.crud.dto.CreateUserRequest;
import com.farhan.crud.entity.User;
import com.farhan.crud.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceMockitoTest {

    @Mock
    UserRepository repository;

    @InjectMocks
    UserService service;

    @Test
    void shouldCreateUser() {

        CreateUserRequest request = new CreateUserRequest();

        request.name = "Mockito";
        request.email = "mockito@test.com";
        request.age = 20;

        when(repository.findByEmail(request.email))
                .thenReturn(Optional.empty());

        User user = service.create(request);

        assertNotNull(user);
        assertEquals("Mockito", user.name);
        assertEquals("mockito@test.com", user.email);

        verify(repository).persist(any(User.class));
    }

}