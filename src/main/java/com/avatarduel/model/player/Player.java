package com.avatarduel.model.player;

import java.util.List;
import java.util.Random;
import com.avatarduel.model.card.*;
import com.avatarduel.model.constant.Element;


public class Player {
  public final int numberOfStartingCard = 7;
  public final int initialPlayerHealth = 80;
  private static int countPlayer = 0;
  private int playerId;
  private String name;
  private int health;
  private int power[];
  private int totalPower[];
  private List<Card> decks;
  private List<Card> cards;

  public Player(String name, List<Card> decks){
    this.name = name;
    this.health = initialPlayerHealth;
    this.playerId = ++countPlayer;
    this.power = new int[Element.numberElmt];
    this.totalPower = new int[Element.numberElmt];
    this.decks = decks;
    this.moveDecksToCards(numberOfStartingCard);
  }

  public String getName(){
    return this.name;
  }

  public int getHealth(){
    return this.health;
  }

  public int getPower(int idx){
    return this.power[idx];
  }

  public int getTotalPower(int idx) {
    return this.totalPower[idx];
  }

  public List<Card> getCards() {
    return this.cards;
  }

  public int setPower(int idx, int val) {
    this.power[idx] = val;
  }

  public int setTotalPower(int idx, int val) {
    this.totalPower[idx] = val;
  }

  public void moveDecksToCards(int numberOfCard){
    for(int i = 0; i < numberOfCard; i ++){
      int chosenCardIndex = (int)(Math.random() * ((decks.size() - 0) + 1));
      cards.add(decks.get(chosenCardIndex));
      decks.remove(chosenCardIndex);
    }
  }
 
}