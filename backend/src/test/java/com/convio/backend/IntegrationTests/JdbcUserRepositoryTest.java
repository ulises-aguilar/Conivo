package com.convio.backend.IntegrationTests;

import java.util.UUID;
import java.util.List;

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

    @BeforeEach
    void setup(){

        User user1 = new User(
            UUID.randomUUID(),
            "1234",
            "john@ewu.edu"
        );

        User user2 = new User(
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
    

}
