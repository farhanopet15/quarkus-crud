package com.farhan.crud.auth.dto;

public class AuthResponse {

    public String accessToken;

    public AuthResponse() {
    }

    public AuthResponse(String accessToken) {
        this.accessToken = accessToken;
    }

}