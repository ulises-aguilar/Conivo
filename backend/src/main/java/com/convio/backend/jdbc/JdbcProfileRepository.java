package com.convio.backend.jdbc;

import java.util.List;

import com.convio.backend.model.Profile;
import com.convio.backend.repository.ProfileRepository;

public class JdbcProfileRepository implements ProfileRepository{

    @Override
    public List<Profile> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public List<Profile> findByUser_id() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByUser_id'");
    }

    @Override
    public List<Profile> findByName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByName'");
    }

    @Override
    public List<Profile> findByDob() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByDob'");
    }

    @Override
    public List<Profile> findByGender() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByGender'");
    }

    @Override
    public List<Profile> findByCity() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByCity'");
    }

    @Override
    public List<Profile> findByMajor() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByMajor'");
    }

    @Override
    public int update(Profile profile) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int save(Profile profile) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public int delete(Profile profile) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
