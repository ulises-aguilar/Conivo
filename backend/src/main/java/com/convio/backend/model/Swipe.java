package com.convio.backend.model;

import java.util.UUID;

public class Swipe {

    private UUID swiper_id;
    private UUID target_id;
    private boolean decision;

    public Swipe(){};

    public Swipe(UUID swiper, UUID target, boolean decision){
        this.swiper_id = swiper;
        this.target_id = target;
        this.decision = decision;
    }


    //Getters

    public UUID getSwiper(){return this.swiper_id;}
    public UUID getTarget(){return this.target_id;}
    public boolean getDecision(){return this.decision;}

    //Setters
    public void setSwiper(UUID id){this.swiper_id = id;}
    public void setTarget(UUID id){this.target_id = id;}
    public void setDecision(boolean decision){this.decision = decision;}
}
