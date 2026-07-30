package com.convio.backend.repository;

import java.util.Optional;

import com.convio.backend.model.Message;

public interface MessageRepository {

    Iterable<Message> findAll();
    Optional<Message> findBySender_id();
    Optional<Message> findByMatch_id();
    
    boolean update(Message message);
    boolean save(Message message);
    boolean delete(Message message);




}
