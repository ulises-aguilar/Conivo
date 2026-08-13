package com.convio.backend.IntegrationTests;

import com.convio.backend.jdbc.JdbcSwipeRepository;
import com.convio.backend.model.User;
import com.convio.backend.model.Swipe;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

@Transactional
@SpringBootTest
@Import(JdbcSwipeRepository.class)
public class JdbcSwipeRepositoryTest {

    @Autowired
    private JdbcSwipeRepository repository;

    private User user1;
    private User user2;
    private User user3;

    private Swipe swipe1;
    private Swipe swipe2;

    @BeforeEach
    void setup(){

        user1 = new User(
            UUID.randomUUID(),
            "1",
            "john@ewu.edu"
        );

        user2 = new User(
            UUID.randomUUID(),
            "2",
            "apple@ewu.edu"
        );

        user3 = new User(
            UUID.randomUUID(),
            "3",
            "seed@ewu.edu"
        );

        swipe1 = new Swipe(
            user1.getId(), 
            user2.getId(), 
            false
        );

        swipe2 = new Swipe(
            user1.getId(),
            user3.getId(),
            true
        );



        @Test
        void returnAllSwipes(){

            List<Swipe> result = repository.findAll();

            assertEquals(2, result.size());
        }






    }


}
