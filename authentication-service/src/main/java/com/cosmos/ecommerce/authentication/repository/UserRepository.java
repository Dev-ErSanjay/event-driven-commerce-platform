package com.cosmos.ecommerce.authentication.repository;

import com.cosmos.ecommerce.authentication.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {

    private Map<String, User> users = new HashMap<>();

    public void save(User user) {

        users.put(user.getEmail(), user);
    }

    public Optional<User> findByEmail(String email) {

        return Optional.ofNullable(
                users.get(email));
    }

}