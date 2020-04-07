package com.avatarduel.model.card;

public interface ISummoned {
    public boolean isOccupied();
    public void setEmpty();
    public void insertCard(Card card);
}