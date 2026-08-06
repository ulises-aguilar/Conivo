package com.convio.backend.jdbc;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.convio.backend.model.User;
import com.convio.backend.repository.UserRepository;

@Repository
public class JdbcUserRepository implements UserRepository{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcUserRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(
            "select id, universityId, universityEmail, email_verified from Users",
            this::mapRowToUser);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        List<User> results =  jdbcTemplate.query(
        "select *, from Users where university ", 
        this::mapRowToUser, 
        email);

        return results.size() == 0 ?
        Optional.empty() :
        Optional.of(results.get(0));
        
    }

    @Override
    public Optional<User> findByUniId(String id) {
        List<User> results =  jdbcTemplate.query(
        "select *, from Users where universityId= ? ", 
        this::mapRowToUser, 
        id);

        return results.size() == 0 ? 
        Optional.empty() :
        Optional.of(results.get(0));
         
    }

    @Override
    public Optional<User> findById(UUID id) {
        List<User> results =  jdbcTemplate.query(
        "select *, from Users where id =  ? ", 
        this::mapRowToUser, 
        id);

        return results.size() == 0 ? 
        Optional.empty() :
        Optional.of(results.get(0));
    
    }
    @Override
    public boolean update(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public User save(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public boolean delete(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }



    private User mapRowToUser(ResultSet row, int rowNum) throws SQLException{
        return new User(
            row.getObject("id", UUID.class),
            row.getString("universityId"),
            row.getString("universityEmail")

        );
    }
}
