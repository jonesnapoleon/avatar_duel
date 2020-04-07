package com.avatarduel.model.card;

import com.avatarduel.model.card.constant.Element;

abstract public class Card {
  private int id;
  private String name;
  private String description;
  private Element element;

  public Card() {
    this.id = 0;
    this.name = "";
    this.description = "";
    this.element = Element.AIR;
  }

  public Card(int id, String name, String description, Element element) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.element = element;
  }

  public int getId() {
    return this.id;
  }

  public String getName(){
    return this.name;
  }

  public String getDesc(){
    return this.description;
  }

  public Element getElement(){
    return this.element;
  }

  public void setName(String name){
    this.name = name;
  }

  public void setDesc(String desc){
    this.description = desc;
  }

  public void setElement(Element e){
    this.element = e;
  }

  public void ShowInfo(){
    System.out.println("Name: " + this.name);
    System.out.println("Element: " + this.element);
    System.out.println("Description: " + this.description);
  }
}