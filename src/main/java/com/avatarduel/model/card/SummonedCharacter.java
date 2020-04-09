package com.avatarduel.model.card;

import com.avatarduel.model.card.constant.CardState;
import com.avatarduel.ErrorClass;
import java.util.List;
import java.util.ArrayList;

public class SummonedCharacter implements ISummoned {
    private CardState state;
    private boolean occupied;
    private boolean powerUp;
    private Character character;
    private List<SummonedSkill> skills;

    public SummonedCharacter() {
        this.occupied = false;
        this.powerUp = false;
        this.skills = new ArrayList<SummonedSkill>();
    }

    public boolean isOccupied(){
        return this.occupied;
    }

    public List<SummonedSkill> getSSkill() {
        return this.skills;
    }

    public CardState getCardState() {
        return this.state;
    }

    public boolean getPowerUp() {
        return this.powerUp;
    }

    public void setPowerUp(boolean powerUp) {
        this.powerUp = powerUp;
    }

    public int getStateValue() {
        if (this.state == CardState.ATTACK)
            return character.getAttack();
        else
            return character.getDefense();
    }

    public void addSkill(SummonedSkill s) {
        this.skills.add(s);
    }

    public void removeCard(){
        this.skills.forEach(summonedSkill -> summonedSkill.removeCard());
        this.skills.clear();
        this.occupied = false;
    }

    public Character getCharacter() {
        return this.character;
    }

    public void insertCard(Card x) throws ErrorClass {
        if(x instanceof Character){
            this.character  = (Character)x;
        }
        else{
            throw new ErrorClass("Tipe card harus character!!");
        }
        this.occupied = true;
    }

    public void setPosition(CardState c){
        this.state = c;
    }

    public void rotate() {
        if (this.state == CardState.ATTACK)
            this.state = CardState.DEFENSE;
        else
            this.state = CardState.ATTACK;
    }
}