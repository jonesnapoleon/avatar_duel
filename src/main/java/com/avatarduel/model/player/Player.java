package com.avatarduel.model.player;

import java.util.*;

import com.avatarduel.ErrorClass;
import com.avatarduel.model.card.*;
import com.avatarduel.model.card.Character;
import com.avatarduel.model.card.constant.Element;
import com.avatarduel.model.card.constant.*;

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
  private List<Card> hands;
  private SummonedSkill skills[];
  private SummonedCharacter chars[];

  public Player(String name, List<Card> decks, int numOfCardsInField){
    this.name = name;
    this.health = initialPlayerHealth;
    this.playerId = ++countPlayer;
    this.power = new int[Element.numberElmt];
    this.totalPower = new int[Element.numberElmt];
    this.decks = decks;
    this.skills = new SummonedSkill[numOfCardsInField];
    this.chars = new SummonedCharacter[numOfCardsInField];
    this.hands = new ArrayList<Card>();
    this.moveDecksToHands(numberOfStartingCard);
    for (int i = 0; i < Element.numberElmt; i++) {
      this.power[i] = 0;
      this.totalPower[i] = 0;
    }
    for (int i = 0; i < numOfCardsInField; i++) {
      this.skills[i] = new SummonedSkill();
      this.chars[i] = new SummonedCharacter();
    }
  }

  public SummonedCharacter[] getChar() {
    return this.chars;
  }

  public SummonedSkill[] getSkills() {
    return this.skills;
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

  public List<Card> getCardsfromHand() {
    return this.hands;
  }

  public void setPower(int idx, int val) {
    this.power[idx] = val;
  }

  public void setTotalPower(int idx, int val) {
    this.totalPower[idx] = val;
  }

  public void moveDecksToHands(int numberOfCard){
    for(int i = 0; i < numberOfCard; i ++){
      int chosenCardIndex = (int)(Math.random() * ((decks.size() - 0) + 1));
      hands.add(decks.get(chosenCardIndex));
      decks.remove(chosenCardIndex);
    }
  }

  public void moveCharToField(int idx, int cardId, CardState cardState) {
    Card removed = hands.stream().filter(card -> (cardId == card.getId())).findAny().orElse(null);
    if (!(removed == null)) {
      Character cast = (Character)removed;
      if (cast.getPower() <= this.power[cast.getElement().ordinal()]) {
        hands.remove(removed);
        try {
          if (!chars[idx].isOccupied()) {
            chars[idx].insertCard(removed);
            chars[idx].setPosition(cardState);
          }
        } catch(ErrorClass exc) {
          System.out.println(exc.getMessage());
        }
        this.power[cast.getElement().ordinal()] -= cast.getPower();
      } else {
        // Throw power not enough exception
      }
    } else {
      // Throw invalid card exception
    }
  }

  public void moveSkillToField(int idx, int cardId, SummonedCharacter summonedCharacter) {
    Card removed = hands.stream().filter(card -> (cardId == card.getId())).findAny().orElse(null);
    if (!(removed == null)) {
      // Potential Error
      Skill cast = (Skill)removed;
      if (cast.getPower() <= this.power[cast.getElement().ordinal()]) {
        hands.remove(removed);
        try {
          if (!skills[idx].isOccupied()) {
            skills[idx].insertCard(removed);
            summonedCharacter.addSkill(skills[idx]);
            skills[idx].addCharacter(summonedCharacter);
          }
        } catch(ErrorClass exc) {
          System.out.println(exc.getMessage());
        }
        this.power[cast.getElement().ordinal()] -= cast.getPower();
      } else {
        // Throw power not enough exception
      }
    } else {
      // Throw invalid card exception
    }
  }

  public void playLandCard(int cardId) {
    Card removed = hands.stream().filter(card -> (cardId == card.getId())).findAny().orElse(null);
    if (!(removed == null)) {
      if (removed instanceof Land) {
        hands.remove(removed);
        this.power[((Land)removed).getElement().ordinal()] += 1;
        this.totalPower[((Land)removed).getElement().ordinal()] += 1;
      } else {
        // Throw invalid type
      }
    } else {
      // Throw invalid card exception
    }
  }

  public void killChar(int idx) {
    if (this.chars[idx].isOccupied()) {
      this.chars[idx].removeCard();
    }
  }

  public void removeSkill(int idx) {
    if (this.skills[idx].isOccupied()) {
      this.skills[idx].getSChar().getSSkill().remove(this.skills[idx]);
      this.skills[idx].removeCard();
    }
  }
}