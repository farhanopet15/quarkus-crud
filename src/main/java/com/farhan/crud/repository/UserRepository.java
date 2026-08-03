package com.farhan.crud.repository;

import com.farhan.crud.dto.UserFilterRequest;
import com.farhan.crud.entity.User;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

    public Optional<User> findByEmail(String email) {
        return find("email", email).firstResultOptional();
    }

    public PanacheQuery<User> search(UserFilterRequest request) {

        String sortColumn = switch (request.sort.toLowerCase()) {
            case "name" -> "name";
            case "email" -> "email";
            case "age" -> "age";
            default -> "id";
        };

        Sort.Direction direction =
                request.direction.equalsIgnoreCase("desc")
                        ? Sort.Direction.Descending
                        : Sort.Direction.Ascending;

        Sort sort = Sort.by(sortColumn, direction);

        String keyword = request.keyword == null ? "" : request.keyword.trim();

        if (keyword.isBlank()) {
            return find("deletedAt IS NULL", sort);
        }

        return find(
                "deletedAt IS NULL AND (LOWER(name) LIKE ?1 OR LOWER(email) LIKE ?1)",
                sort,
                "%" + keyword.toLowerCase() + "%"
        );
    }

}