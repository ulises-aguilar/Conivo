package com.convio.backend.model;

import java.util.UUID;

public class Profile {

    private UUID user_id;
    private String name;
    private String DOB;
    private String bio;
    private String gender;
    private String major;
    private String city;


    public Profile(){};

    public Profile(UUID user_id, String name, String dob, String bio, String gender
        , String major, String city)
        {
            this.user_id = user_id;
            this.name = name;
            this.DOB = dob;
            this.bio = bio;
            this.gender = gender;
            this.major = major;
            this.city = city;
        }

    
    //Setters
    public void setUser_id(UUID id){this.user_id = id;}
    public void setName(String name){this.name = name;}
    public void setDOB(String dob){this.DOB = dob;}
    public void setBio(String bio){this.bio = bio;}
    public void setGender(String gender){this.gender = gender;}
    public void setMajor(String major){this.major = major;}
    public void setCity(String city){this.city = city;}

    //Getters
    public UUID getUser_id(){return this.user_id;}
    public String getName(){return this.name;}
    public String getDob(){return this.DOB;}
    public String getBio(){return this.bio;}
    public String getGender(){return this.gender;}
    public String getMajor(){return this.major;}
    public String getCity(){return this.city;}
    


}
