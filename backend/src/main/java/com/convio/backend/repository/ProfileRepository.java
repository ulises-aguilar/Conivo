package com.convio.backend.repository;

import com.convio.backend.model.Profile;

import java.util.Optional;

public interface ProfileRepository {

    Iterable<Profile> findAll();
    Optional<Profile> findByUser_id();
    Optional<Profile> findByName();
    Optional<Profile> findByDob();
    Optional<Profile> findByGender();
    Optional<Profile> findByCity();
    Optional<Profile> findByMajor();

    boolean update(Profile profile);
    boolean save(Profile profile);
    boolean delete(Profile profile);


}
