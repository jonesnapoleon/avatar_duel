package com.avatarduel.model.card;
import com.avatarduel.ErrorClass;

public class SummonedSkill implements ISummoned {
    private boolean occupied;
    private Skill skill;
    private SummonedCharacter summonedCharacter;

    public SummonedSkill(){
        this.occupied = false;
    }

    public SummonedCharacter getSChar() {
        return this.summonedCharacter;
    }

    public boolean isOccupied(){
        return this.occupied;
    }

    public void removeCard(){
        this.skill.deactivate(summonedCharacter);
        this.occupied = false;
    }

    public void addCharacter(SummonedCharacter s) {
        this.summonedCharacter = s;
        this.skill.activate(this.summonedCharacter);
    }

    public void insertCard(Card x) throws ErrorClass {
        if(x instanceof Skill){
            this.skill = (Skill)x;
        }
        else{
            throw new ErrorClass("Tipe card harus skill!!");
        }
        this.occupied = true;
    }
}