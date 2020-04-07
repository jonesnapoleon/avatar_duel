package com.avatarduel.model.card;
import com.avatarduel.model.card.constant.Element;

public class Character extends Card {
  private int attack;
  private int defense;
  private int power;

  public Character() {
    super();
    this.attack = 0;
    this.defense = 0;
    this.power = 0;
  }

  public Character(String name, String description, Element element, int power, int attack, int defense) {
    super(name, description, element);
    this.attack = attack;
    this.defense = defense;
    this.power = power;
  }

  public int getAttack() {
    return this.attack;
  }

  public int getDefense() {
    return this.defense;
  }

  public int getPower(){
    return this.power;
  }

  public void setAttack(int attack){
    this.attack = attack;
  }

  public void setDefense(int defense){
    this.defense = defense;
  }

  public void setPower(int power){
    this.power = power;
  }

  public void ShowInfo(){
    super.ShowInfo();
    System.out.println("Attack: " + this.attack);
    System.out.println("Defense: " + this.defense);
    System.out.println("Power: " + this.power);
  }
}