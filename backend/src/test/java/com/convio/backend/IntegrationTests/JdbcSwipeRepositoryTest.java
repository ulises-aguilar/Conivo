package com.convio.backend.IntegrationTests;

import java.util.List;

import com.convio.backend.jdbc.JdbcSwipeRepository;
import com.convio.backend.jdbc.JdbcUserRepository;
import com.convio.backend.model.User;
import com.convio.backend.model.Swipe;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

@Transactional
@SpringBootTest
@Import(JdbcSwipeRepository.class)
public class JdbcSwipeRepositoryTest {

    @Autowired
    private JdbcSwipeRepository repository;

    @Autowired
    private JdbcUserRepository userRepository;

    private User user1;
    private User user2;
    private User user3;

    private Swipe swipe1;
    private Swipe swipe2;
    private Swipe swipe3;

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

        swipe3 = new Swipe(
            user2.getId(),
            user3.getId(),
        true
        );

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        repository.save(swipe1);
        repository.save(swipe2);
        repository.save(swipe3);



    }

    @Test
    void returnAllSwipes(){

        List<Swipe> result = repository.findAll();

        assertEquals(3, result.size());
    }


    @Test
    void findSwiperById(){

        List<Swipe> result = repository.findBySwiper(user1.getId());

        assertEquals(2, result.size());

        for (Swipe swipe: result){
            assertEquals(user1.getId(), swipe.getSwiper());
        }
    }

    @Test
    void findByTarget(){
        List<Swipe> result = repository.findByTarget(user3.getId());

        assertEquals(2, result.size());

         for (Swipe swipe: result){
            assertEquals(user3.getId(), swipe.getTarget());
        }
    }

    @Test
    void updateSwipe() {

        swipe1.setDecision(true);

        int rows = repository.update(swipe1);

        assertEquals(1, rows);

        List<Swipe> results = repository.findBySwiper(user1.getId());

        for (Swipe swipe : results) {
            if (swipe.getTarget().equals(user2.getId())) {
                assertTrue(swipe.getDecision());
            }
        }
    }

    @Test
    void saveSwipe() {

        Swipe swipe4 = new Swipe(
            user3.getId(),
            user1.getId(),
            false
        );

        int rows = repository.save(swipe4);

        assertEquals(1, rows);

        List<Swipe> results = repository.findAll();

        assertEquals(4, results.size());
    }

    @Test
    void deleteSwipe() {

        int rows = repository.delete(swipe1);

        assertEquals(1, rows);

        List<Swipe> results = repository.findAll();

        assertEquals(2, results.size());

        for (Swipe swipe : results) {
            assertFalse(
                swipe.getSwiper().equals(user1.getId()) &&
                swipe.getTarget().equals(user2.getId())
            );
        }
    }

}










