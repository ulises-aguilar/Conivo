package com.convio.backend.repository;

import com.convio.backend.model.Profile;

import java.util.List;

public interface ProfileRepository {

    List<Profile> findAll();
    List<Profile> findByUser_id();
    List<Profile> findByName();
    List<Profile> findByDob();
    List<Profile> findByGender();
    List<Profile> findByCity();
    List<Profile> findByMajor();

    int update(Profile profile);
    int save(Profile profile);
    int delete(Profile profile);


}
