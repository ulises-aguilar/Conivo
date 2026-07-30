package com.convio.backend.model;

import java.util.UUID;

public class Preference {

    private UUID user_id;
    private int min_age;
    private int max_age;
    private int max_distance;
    private String gender;
    private String major;

    public Preference(){};

    public Preference(UUID user_id, int min_age, int max_age,
        int max_distance, String gender, String major){
            this.user_id = user_id;
            this.min_age = min_age;
            this.max_age = max_age;
            this.max_distance = max_distance;
            this.gender = gender;
            this.major = major;
        }

    //Setters
    public void setUser_id(UUID user_id){this.user_id = user_id;}
    public void setMin_age(int min_age){this.min_age = min_age;}
    public void setMax_age(int max_age){this.max_age = max_age;}
    public void setMax_distance(int max_distance){this.max_distance = max_distance;}
    public void setGender(String gender){this.gender = gender;}
    public void setMajor(String major){this.major = major;}

    //Getters
    public UUID getUser_id(){return this.user_id;}
    public int getMin_age(){return this.min_age;}
    public int getMax_age(){return this.max_age;}
    public int getMax_distance(){return this.max_distance;}
    public String getGender(){return this.gender;}
    public String getMajor(){return this.major;}
}
