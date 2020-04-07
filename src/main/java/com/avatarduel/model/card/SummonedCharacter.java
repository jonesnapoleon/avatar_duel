package com.avatarduel.model.card;

import com.avatarduel.model.card.constant.CardState;

public class SummonedCharacter implements ISummoned  {
    private CardState state;
    private Character character;
    private boolean occupied;

    public SummonedCharacter() {
        occupied = false;
    }

    public void addCharacter(Character character, CardState state) {
        this.character = character;
        this.state = state;
        this.occupied = true;
    }

    public void removeCharacter() {
        this.occupied = false;
    }

    public void rotate() {
        if (this.state == CardState.ATTACK)
            this.state = CardState.DEFENSE;
        else
            this.state = CardState.ATTACK;
    }

    public CardState getCardState() {
        return this.state;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public int getStateValue() {
        if (this.state == CardState.ATTACK)
            return this.character.getAttack();
        else
            return this.character.getDefense();
    }
}