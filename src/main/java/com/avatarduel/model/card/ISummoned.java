package com.avatarduel.model.card;

public interface ISummoned {
    public boolean isOccupied();
    public void removeCard();
    public void insertCard(Card card);
    // public void printInfo();
}