package com.convio.backend.repository;

import com.convio.backend.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    Iterable<User> findAll();
    Optional<User> findByEmail(String email);
    Optional<User> findByUniId(String id);
    Optional<User> findById(UUID id);

    boolean update(User user);
    boolean save(User user);
    boolean delete(User user);


}
