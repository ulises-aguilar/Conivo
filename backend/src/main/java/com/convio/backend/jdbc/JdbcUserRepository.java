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
        
        jdbcTemplate.update(
            """
            UPDATE Users SET universityId = ?,
            universityEmail = ?,
            email_verified = ? 
            WHERE id = ?"
            """, 
            user.getUniversityId(),
            user.getUniversityEmail(),
            user.getEmail_verified(),
            user.getId()
        );

        return true;
    }

    @Override
    public boolean save(User user) {
        jdbcTemplate.update(
            """
            INSERT into USERS (id, universityId, universityEmail, email_verified)
            values (?,?,?,?)
            """,
            user.getId(),
            user.getUniversityId(),
            user.getUniversityEmail(),
            user.getEmail_verified()
        );

        return true;

    }

    @Override
    public boolean delete(User user) {

        jdbcTemplate.update(
            """
            DELETE from Users 
            WHERE id = ?
            """,
            user.getId()
        );

        return true;
    }


    private User mapRowToUser(ResultSet row, int rowNum) throws SQLException{
        return new User(
            row.getObject("id", UUID.class),
            row.getString("universityId"),
            row.getString("universityEmail")

        );
    }
}
