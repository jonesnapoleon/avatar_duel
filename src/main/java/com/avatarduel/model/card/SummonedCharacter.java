package com.avatarduel.model.card;

import com.avatarduel.model.card.constant.CharState;
import com.avatarduel.ErrorClass;

public class SummonedCharacter extends Character implements ISummoned {
    private CharState state;
    private boolean occupied;

    public SummonedCharacter() {
        super();
        this.occupied = false;
    }

    public boolean isOccupied(){
        return this.occupied;
    }

    public CharState getCharState() {
        return this.state;
    }

    public int getStateValue() {
        if (this.state == CharState.ATTACK)
            return this.getAttack();
        else
            return this.getDefense();
    }

    public void removeCard(){
        this.occupied = false;
    }

    public void insertCard(Card x){
        if(x instanceof Character){
            Character y  = (Character)x;
            this.setAttack(y.getAttack());
            this.setDefense(y.getDefense());
            this.setPower(y.getPower());
        }
        else{
            throw new ErrorClass("Tipe card harus character!!");
        }
        this.occupied = true;
        this.setName(x.getName());
        this.setDesc(x.getDesc());
        this.setElement(x.getElement());
    }

    public void setPosition(CharState c){
        this.state = c;
    }

    public void removeCharacter() {
        this.occupied = false;
    }

    public void rotate() {
        if (this.state == CharState.ATTACK)
            this.state = CharState.DEFENSE;
        else
            this.state = CharState.ATTACK;
    }
}