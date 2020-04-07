package com.avatarduel.model.card;
import com.avatarduel.model.card.constant.Element;

public class Land extends Card {
  
  public Land() {
    super();
  }

  public Land(int id, String name, String description, Element element) {
    super(id, name, description, element);
  }

  public void ShowInfo(){
    super.ShowInfo();
  }
}