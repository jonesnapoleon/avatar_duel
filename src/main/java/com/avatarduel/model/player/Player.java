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
  private List<Card> decks;
  private List<Card> cards;

  public Player(String name, List<Card> decks){
    this.name = name;
    this.health = initialPlayerHealth;
    this.playerId = ++countPlayer;
    this.power = new int[Element.numberElmt];
    this.decks = decks;
    this.moveDecksToCards(numberOfStartingCard);
  }

  public String getName(){
    return this.name;
  }

  public int getHealth(){
    return this.health;
  }

  public int gerPower(int idx){
    return this.power[idx];
  }

  public List<Card> getCards() {
    return this.cards;
  }

  public void moveDecksToCards(int numberOfCard){
    for(int i = 0; i < numberOfCard; i ++){
      int chosenCardIndex = (int)(Math.random() * ((decks.size() - 0) + 1));
      cards.add(decks.get(chosenCardIndex));
      decks.remove(chosenCardIndex);
    }
  }
 
}