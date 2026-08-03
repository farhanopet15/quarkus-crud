package com.farhan.crud.exception;

public class ErrorResponse {

    public boolean success;
    public String message;

    public ErrorResponse() {
    }

    public ErrorResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}