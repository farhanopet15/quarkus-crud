package com.farhan.crud.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class RegisterRequest {

    @NotBlank
    public String name;

    @Email
    @NotBlank
    public String email;

    @NotBlank
    public String password;

    @Min(1)
    public Integer age;

}