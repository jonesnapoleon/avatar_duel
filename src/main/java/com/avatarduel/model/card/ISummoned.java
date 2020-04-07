package com.avatarduel.model.card;
import com.avatarduel.ErrorClass;

public interface ISummoned {
    public boolean isOccupied();
    public void removeCard();
    public void insertCard(Card card) throws ErrorClass;
    // public void printInfo();
}