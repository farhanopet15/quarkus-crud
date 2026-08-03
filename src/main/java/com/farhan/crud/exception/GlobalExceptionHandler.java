package com.farhan.crud.exception;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {

        if(exception instanceof NotFoundException){

            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorResponse(false, exception.getMessage()))
                    .type(MediaType.APPLICATION_JSON)
                    .build();

        }

        if(exception instanceof RuntimeException){

            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorResponse(false, exception.getMessage()))
                    .type(MediaType.APPLICATION_JSON)
                    .build();

        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorResponse(false,"Internal Server Error"))
                .type(MediaType.APPLICATION_JSON)
                .build();

    }

}