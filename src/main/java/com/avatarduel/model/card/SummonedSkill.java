package com.avatarduel.model.card;

public class SummonedSkill extends Skill implements ISummoned {
    private boolean occupied; 

    SummonedSkill(){
        super();
        this.occupied = false;
    }

    @Override
    public void setEmpty(){
        this.occupied = false;
    }

    @Override
    public void setCard(Card x){
        this.occupied = false;
        this.
    }
}