package com.farhan.crud.repository;

import com.farhan.crud.entity.User;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import com.farhan.crud.dto.UserFilterRequest;

import java.util.Optional;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

    public Optional<User> findByEmail(String email) {
        return find("email", email).firstResultOptional();
    }

    public PanacheQuery<User> search(String keyword, String sort) {

        Sort sorting = Sort.by(sort == null || sort.isBlank() ? "id" : sort);

        if (keyword == null || keyword.isBlank()) {
            return findAll(sorting);
        }

        return find(
                "LOWER(name) LIKE LOWER(?1) OR LOWER(email) LIKE LOWER(?1)",
                sorting,
                "%" + keyword + "%"
        );
    }

    public PanacheQuery<User> search(UserFilterRequest request) {

        String sortColumn = switch (request.sort) {

            case "name" -> "name";
            case "email" -> "email";
            case "age" -> "age";
            default -> "id";

        };

        Sort.Direction direction =
                request.direction.equalsIgnoreCase("desc")
                        ? Sort.Direction.Descending
                        : Sort.Direction.Ascending;

        Sort sort =
                Sort.by(sortColumn, direction);

        if (request.keyword == null || request.keyword.isBlank()) {

            return findAll(sort);

        }

        return find(
                "LOWER(name) LIKE LOWER(?1) OR LOWER(email) LIKE LOWER(?1)",
                sort,
                "%" + request.keyword + "%"
        );

    }

}