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

import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserService service;

        @GET
        public ApiResponse<PageResponse<UserResponse>> getAll(
                @BeanParam UserFilterRequest request
        ){

        PageResponse<User> page =
                service.getAll(request);

        List<UserResponse> users =
                page.content
                        .stream()
                        .map(UserMapper::toResponse)
                        .toList();

        return new ApiResponse<>(

                true,

                "Success",

                new PageResponse<>(

                        users,

                        page.page,

                        page.size,

                        page.totalData,

                        page.totalPage

                )

        );

        }
    @GET
    @Path("/{id}")
    public ApiResponse<UserResponse> getById(@PathParam("id") Long id){

        return new ApiResponse<>(
                true,
                "Success",
                UserMapper.toResponse(service.getById(id))
        );

    }

    @POST
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
    public ApiResponse<String> delete(@PathParam("id") Long id){

        service.delete(id);

        return new ApiResponse<>(
                true,
                "User deleted successfully",
                null
        );

    }

}