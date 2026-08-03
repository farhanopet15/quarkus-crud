package com.farhan.crud.dto;

import java.util.List;

public class PageResponse<T> {

    public List<T> content;
    public int page;
    public int size;
    public long totalData;
    public int totalPage;

    public PageResponse() {
    }

    public PageResponse(List<T> content,
                        int page,
                        int size,
                        long totalData,
                        int totalPage) {

        this.content = content;
        this.page = page;
        this.size = size;
        this.totalData = totalData;
        this.totalPage = totalPage;

    }

}