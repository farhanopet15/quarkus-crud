package com.farhan.crud.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class CreateUserRequest {

    @NotBlank
    public String name;

    @Email
    @NotBlank
    public String email;

    @Min(1)
    public Integer age;
}