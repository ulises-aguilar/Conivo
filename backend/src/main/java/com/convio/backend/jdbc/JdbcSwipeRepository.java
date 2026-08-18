package com.convio.backend.jdbc;

import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.convio.backend.model.Swipe;
import com.convio.backend.repository.SwipeRepository;

@Repository
public class JdbcSwipeRepository implements SwipeRepository{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcSwipeRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Swipe> findAll(){

        return jdbcTemplate.query(
        """
        SELECT *
        FROM swipes
        """,
        this::mapRowToSwipe
    );

    }

    @Override
    public List<Swipe> findBySwiper(UUID id){

        return jdbcTemplate.query(
            """
            SELECT swiper_id,
                target_id,
                decision
            FROM swipes
            WHERE swiper_id = ?
            """,
            this::mapRowToSwipe,
            id
        );
    }

    @Override
    public List<Swipe> findByTarget(UUID id){

        return jdbcTemplate.query(
        """
        SELECT swiper_id,
               target_id,
               decision
        FROM swipes
        WHERE target_id = ?
        """,
        this::mapRowToSwipe,
        id
    );

    }

    @Override
    public boolean update(Swipe swipe){

        int rowsAffected = jdbcTemplate.update(
        """
        UPDATE swipes
        SET target_id = ?,
            decision = ?
        WHERE swiper_id = ?
        """,
        swipe.getSwiper(),
        swipe.getTarget(),
        swipe.getDecision(),
        swipe.getSwiper()
    );

    return true;
    }

    @Override
    public boolean save(Swipe swipe){

        int rowsAffected = jdbcTemplate.update(
        """
        INSERT INTO swipes
        (swiper_id, target_id, decision)
        VALUES (?, ?, ?)
        """,
        swipe.getSwiper(),
        swipe.getTarget(),
        swipe.getDecision()
        );

        return true;
    }

    @Override
    public boolean delete(Swipe swipe){
        
        int rowsAffected = jdbcTemplate.update(
        """
        DELETE FROM swipes
        WHERE swiper_id = ?
          AND target_id = ?
        """,
        swipe.getSwiper(),
        swipe.getTarget()
    );

    return true;
    }


    private Swipe mapRowToSwipe(ResultSet row, int rowNum) throws SQLException{
        return new Swipe(
            row.getObject("swiper_id", UUID.class),
            row.getObject("target_id", UUID.class),
            row.getBoolean("decision")
        );

    }




}
