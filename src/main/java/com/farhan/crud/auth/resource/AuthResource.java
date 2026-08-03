package com.farhan.crud.auth.resource;

import com.farhan.crud.auth.dto.LoginRequest;
import com.farhan.crud.auth.dto.RegisterRequest;
import com.farhan.crud.auth.service.AuthService;
import com.farhan.crud.dto.ApiResponse;
import com.farhan.crud.entity.User;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthResource {

    @Inject
    AuthService service;

    @POST
    @Path("/register")
    public ApiResponse<String> register(@Valid RegisterRequest request) {

        User user = service.register(request);

        return new ApiResponse<>(
                true,
                "Register Success",
                user.email
        );
    }

    @POST
    @Path("/login")
    public ApiResponse<String> login(@Valid LoginRequest request) {

        User user = service.login(request);

        return new ApiResponse<>(
                true,
                "Login Success",
                "Login berhasil untuk " + user.email
        );
    }
}