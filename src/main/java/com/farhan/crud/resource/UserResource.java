package com.farhan.crud.resource;

import com.farhan.crud.dto.ApiResponse;
import com.farhan.crud.dto.CreateUserRequest;
import com.farhan.crud.dto.UpdateUserRequest;
import com.farhan.crud.dto.UserResponse;
import com.farhan.crud.entity.User;
import com.farhan.crud.mapper.UserMapper;
import com.farhan.crud.service.UserService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import com.farhan.crud.dto.PageResponse;
import jakarta.ws.rs.BeanParam;
import com.farhan.crud.dto.UserFilterRequest;
import com.farhan.crud.dto.PageResponse;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "User API", description = "User Management Endpoint")

public class UserResource {

    @Inject
    UserService service;

        @GET
        @Operation(summary = "Get all users")
        public ApiResponse<PageResponse<UserResponse>> getAll(
                @BeanParam UserFilterRequest request
        ) {

        PageResponse<User> page = service.getAll(request);

        List<UserResponse> users = page.content
                .stream()
                .map(UserMapper::toResponse)
                .toList();

        PageResponse<UserResponse> response = new PageResponse<>(
                users,
                page.page,
                page.size,
                page.totalData,
                page.totalPage
        );

        return new ApiResponse<>(
                true,
                "Success",
                response
        );

        }

        @GET
        @Path("/{id}")
        @Operation(summary = "Get user by id")
    public ApiResponse<UserResponse> getById(@PathParam("id") Long id){

        return new ApiResponse<>(
                true,
                "Success",
                UserMapper.toResponse(service.getById(id))
        );

    }

        @POST
        @Operation(summary = "Create new user")
    public ApiResponse<UserResponse> create(@Valid CreateUserRequest request){

        User user = service.create(request);

        return new ApiResponse<>(
                true,
                "User created successfully",
                UserMapper.toResponse(user)
        );

    }

        @PUT
        @Path("/{id}")
        @Operation(summary = "Update user")
    public ApiResponse<UserResponse> update(
            @PathParam("id") Long id,
            @Valid UpdateUserRequest request){

        User user = service.update(id, request);

        return new ApiResponse<>(
                true,
                "User updated successfully",
                UserMapper.toResponse(user)
        );

    }

        @DELETE
        @Path("/{id}")
        @Operation(summary = "Delete user")
    public ApiResponse<String> delete(@PathParam("id") Long id){

        service.delete(id);

        return new ApiResponse<>(
                true,
                "User deleted successfully",
                null
        );

    }

}