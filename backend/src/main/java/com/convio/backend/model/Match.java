package com.convio.backend.model;

import java.util.UUID;
import java.time.LocalDateTime;

public class Match {

    private UUID id;
    private User user1_id;
    private User user2_id;
    private LocalDateTime timestamp;

    public Match(){};

    public Match(UUID id, User user1_id, User user2_id, LocalDateTime timestamp){
        this.id = id;
        this.user1_id = user1_id;
        this.user2_id = user2_id;
        this.timestamp = timestamp;
    }

    //Getters
    public UUID getId(){return id;}
    public User getUser1_id(){return user1_id;}
    public User getUser2_id(){return user2_id;}
    public LocalDateTime getTimestamp(){return timestamp;}

    //Setters
    public void setId(UUID id){this.id = id;}
    public void setUser1(User user){this.user1_id = user;}
    public void setUser2(User user){this.user2_id = user;}
    public void setTimestamp(LocalDateTime time){this.timestamp = time;}


}
