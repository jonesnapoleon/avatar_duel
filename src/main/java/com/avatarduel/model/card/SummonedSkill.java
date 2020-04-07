package com.avatarduel.model.card;
import com.avatarduel.ErrorClass;

public class SummonedSkill extends Skill implements ISummoned {
    private boolean occupied;
    private int charId;

    public SummonedSkill(){
        super();
        this.occupied = false;
        this.charId = 0;
    }

    public boolean isOccupied(){
        return this.occupied;
    }

    public void removeCard(){
        this.occupied = false;
    }

    public int getCharId() {
        return this.charId;
    }

    public void setCharId(int charId) {
        this.charId = charId;
    }

    public void insertCard(Card x) throws ErrorClass {
        if(x instanceof Skill){
            this.setEffect(((Skill)x).getEffect());
        }
        else{
            throw new ErrorClass("Tipe card harus skill!!");
        }
        this.occupied = true;
        this.setName(x.getName());
        this.setDesc(x.getDesc());
        this.setElement(x.getElement());
    }
}