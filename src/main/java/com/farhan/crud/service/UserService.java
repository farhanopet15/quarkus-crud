package com.farhan.crud.service;

import com.farhan.crud.dto.CreateUserRequest;
import com.farhan.crud.dto.UpdateUserRequest;
import com.farhan.crud.entity.User;
import com.farhan.crud.exception.NotFoundException;
import com.farhan.crud.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import com.farhan.crud.dto.PageResponse;
import com.farhan.crud.dto.UserFilterRequest;

import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository repository;

    public PageResponse<User> getAll(UserFilterRequest request){

        var query = repository.search(request);

        long total = query.count();

        query.page(request.page, request.size);

        return new PageResponse<>(

                query.list(),

                request.page,

                request.size,

                total,

                query.pageCount()

        );

    }

    public User getById(Long id) {

    return repository.findByIdOptional(id)
            .orElseThrow(() -> new NotFoundException("User not found"));

    }

    @Transactional
    public User create(CreateUserRequest request){

        if(repository.findByEmail(request.email).isPresent()){
            throw new RuntimeException("Email already exists");
        }

        User user = new User();

        user.name = request.name;
        user.email = request.email;
        user.age = request.age;

        repository.persist(user);

        return user;

    }

    @Transactional
    public User update(Long id, UpdateUserRequest request){

        User user = getById(id);

        repository.findByEmail(request.email)
            .ifPresent(existing -> {

                if(!existing.id.equals(id)){
                    throw new RuntimeException("Email already exists");
                }

            });

        user.name = request.name;
        user.email = request.email;
        user.age = request.age;

    return user;

}

    @Transactional
    public void delete(Long id){

        User user = getById(id);

        repository.delete(user);

    }

}