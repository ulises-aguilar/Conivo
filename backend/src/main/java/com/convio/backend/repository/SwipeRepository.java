package com.convio.backend.repository;

import com.convio.backend.model.Swipe;

import java.util.UUID;
import java.util.List;

public interface SwipeRepository {

    List<Swipe> findAll();
    List<Swipe> findBySwiper(UUID id);
    List<Swipe> findByTarget(UUID id);
    
    boolean update(Swipe swipe);
    boolean save(Swipe swipe);
    boolean delete(Swipe swipe);



    

}
