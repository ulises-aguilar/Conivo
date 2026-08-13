package com.convio.backend.model;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

public class User {

    private UUID id;
    @NotBlank(message="University ID is required ")
    private String universityId;
    @NotBlank(message="University email is required")
    private String universityEmail;
    private boolean email_verified;

    public User(){};

    public User(UUID id, String universityId, String universityEmail){
        this.id = id;
        this.universityId = universityId;
        this.universityEmail = universityEmail;
        this.email_verified = false;
    }

    public User(UUID id, String universityId, String universityEmail, boolean verified){
        this.id = id;
        this.universityId = universityId;
        this.universityEmail = universityEmail;
        this.email_verified = verified;
    }

    public UUID getId(){return id;}

    public void setId(UUID id){this.id = id;}

    public String getUniversityId(){return universityId;}

    public void setuniversityId(String universityId){this.universityId = universityId;}

    public String getUniversityEmail(){return universityEmail;}

    public void setUniversityEmail(String universityEmail){this.universityEmail = universityEmail;}

    public boolean getEmail_verified(){return this.email_verified;}

    public void setEmail_verified(boolean status){this.email_verified = status;}
    
}
