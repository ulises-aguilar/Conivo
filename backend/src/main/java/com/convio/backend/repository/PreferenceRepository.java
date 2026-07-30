package com.convio.backend.repository;

import com.convio.backend.model.Preference;

import java.util.Optional;

public interface PreferenceRepository {

    Iterable<Preference> findAll();
    Optional <Preference> findByUser_id();

}
