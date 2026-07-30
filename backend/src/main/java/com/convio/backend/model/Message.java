package com.convio.backend.model;

import java.util.UUID;

public class Message {

    private UUID id;
    private UUID match_id;
    private UUID sender_id; //Users.id
    private String message;

    public Message(){};

    public Message(UUID id, UUID match_id, UUID sender_id, String message){
        this.id = id;
        this.match_id = match_id;
        this.sender_id = sender_id;
        this.message = message;
    }


    //Getters
    public UUID getId(){return this.id;}
    public UUID getMatch_id(){return this.match_id;}
    public UUID getSender_id(){return this.sender_id;}
    public String getMessage(){return this.message;}

    //Setter
    public void setId(UUID id){this.id = id;}
    public void setMatch_id(UUID id){this.match_id = id;}
    public void setSender_id(UUID id){this.sender_id = id;}
    public void setMessage(String message){this.message = message;}
    


}
