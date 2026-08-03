package com.farhan.crud.mapper;

import com.farhan.crud.dto.UserResponse;
import com.farhan.crud.entity.User;

public class UserMapper {

    public static UserResponse toResponse(User user){

        UserResponse response = new UserResponse();

        response.id = user.id;
        response.name = user.name;
        response.email = user.email;
        response.age = user.age;

        return response;
    }

}