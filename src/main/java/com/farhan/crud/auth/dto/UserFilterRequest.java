package com.farhan.crud.dto;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.QueryParam;

public class UserFilterRequest {

    @QueryParam("keyword")
    @DefaultValue("")
    public String keyword;

    @QueryParam("page")
    @DefaultValue("0")
    public int page;

    @QueryParam("size")
    @DefaultValue("10")
    public int size;

    @QueryParam("sort")
    @DefaultValue("id")
    public String sort;

    @QueryParam("direction")
    @DefaultValue("asc")
    public String direction;

}