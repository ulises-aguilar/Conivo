package com.convio.backend.repository;

import com.convio.backend.model.Swipe;

import java.util.UUID;
import java.util.Optional;

public interface SwipeRepository {

    Iterable<Swipe> findAll();
    Optional<Swipe> findBySwiper(UUID id);
    Optional<Swipe> findByTarget(UUID id);
    
    boolean update(Swipe swipe);
    boolean save(Swipe swipe);
    boolean delete(Swipe swipe);



    

}
