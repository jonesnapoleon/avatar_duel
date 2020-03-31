package com.avatarduel.model.card;
import com.avatarduel.model.constant.Element;
import com.avatarduel.model.constant.SkillEffect;

public class Skill extends Card {
  private SkillEffect effect;
  private int power;

  public Skill() {
    super();
    this.effect = SkillEffect.AURA;
    this.power = 0;
  }

  public Skill(String name, String description, Element element, SkillEffect effect, int power) {
    super(name, description, element);
    this.effect = effect;
    this.power = 0;
  }

  public void ShowInfo(){
    super.ShowInfo();
    System.out.println("Power: " + this.power);
    System.out.println("Skill Effect: " + this.effect);
  }
}