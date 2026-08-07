package com.convio.backend.IntegrationTests;

import java.util.UUID;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import com.convio.backend.jdbc.JdbcUserRepository;
import com.convio.backend.model.User;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@Import(JdbcUserRepository.class)
public class JdbcUserRepositoryTest {

    @Autowired
    private JdbcUserRepository repository;

    private User user1;
    private User user2;

    @BeforeEach
    void setup(){

        user1 = new User(
            UUID.randomUUID(),
            "1234",
            "john@ewu.edu"
        );

        user2 = new User(
            UUID.randomUUID(),
            "4567",
            "apple@ewu.edu"
        );

        repository.save(user1);
        repository.save(user2);

    }

    @Test
    void returnAllUsers(){

        List<User> users = repository.findAll();

        assertEquals(2, users.size());


    }

    @Test
    void returnUserByEmail(){
        Optional<User> user = repository.findByEmail("john@ewu.edu");
        assertEquals("john@ewu.edu", user.get().getUniversityId());


    }

    @Test
    void findUserByUniversityId(){
        Optional<User> user = repository.findByUniId("1234");

        assertEquals("1234", user.get().getUniversityId());
    }

    @Test
    void UpdateUser(){
        user1.setUniversityEmail("changed@ewu.edu");

        repository.update(user1);

        Optional<User> newUser = repository.findByUniId("1234");

        assertEquals(user1.getUniversityEmail(), newUser.get().getUniversityEmail());

    }

    @Test
    void saveUserToDatabase(){
        User user3 = new User(UUID.randomUUID(), "67", "newUser@ewu.edu");
        List<User> results = repository.findAll();

        repository.save(user3);

        assertEquals(3, results.size());

    }
    
    @Test
    void DeleteUser(){

        List<User> results = repository.findAll();

        repository.delete(user1 );

        assertEquals(1, results.size());
    }

}
