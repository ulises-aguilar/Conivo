package com.convio.backend.jdbc;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.convio.backend.model.Swipe;
import com.convio.backend.repository.SwipeRepository;

@Repository
public class JdbcSwipeRepository implements SwipeRepository{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcSwipeRepository(Jdbc jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Swipe> findAll(){

    }

    @Override
    public Optional<Swipe> findBySwiper(UUID id){

    }

    @Override
    public Optional<Swipe> findByTarget(UUID id){

    }

    @Override
    public List<Swipe> findMatchBySwiperId(UUID id){

    }

    @Override
    public boolean update(Swipe swipe){

    }

    @Override
    public boolean save(Swipe swipe){

    }

    @Override
    public boolean delete(Swipe swipe){
        
    }




}
