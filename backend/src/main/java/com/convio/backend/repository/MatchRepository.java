package com.convio.backend.repository;

import com.convio.backend.model.Match;
import com.convio.backend.model.User;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public interface MatchRepository {

    Iterable<Match> findAll();
    Optional<Match> findById(UUID id);
    Optional<Match> findByUser1(User user);
    Optional<Match> findByUser2(User user);
    Optional<Match> findByTimestamp(LocalDateTime time);

    boolean saveMatch(Match match);
    boolean updateMatch(Match match);
    boolean deleteMatch(Match match);

}
