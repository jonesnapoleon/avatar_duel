package com.avatarduel.model.card;

import com.avatarduel.model.constant.Element;

abstract class Card {
  private String name;
  private String description;
  private Element element;

  public Card() {
    this.name = "";
    this.description = "";
    this.element = Element.AIR;
  }

  public Card(String name, String description, Element element) {
    this.name = "";
    this.description = "";
    this.element = Element.AIR;
  }

  public void ShowInfo(){
    System.out.println("Name: " + this.name);
    System.out.println("Element: " + this.element);
    System.out.println("Description: " + this.description);
  }
}