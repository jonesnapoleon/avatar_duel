package com.avatarduel.model.card;
import com.avatarduel.model.card.constant.Element;
import com.avatarduel.model.card.constant.SkillEffect;

abstract public class Skill extends Card {
  private SkillEffect effect;
  private int power;

  public Skill() {
    super();
    this.effect = SkillEffect.AURA;
    this.power = 0;
  }

  public Skill(int id, String name, String description, Element element, int power, SkillEffect effect) {
    super(id, name, description, element);
    this.effect = effect;
    this.power = power;
  }

  public SkillEffect getEffect(){
    return this.effect;
  }

  public int getPower(){
    return this.power;
  }

  public void setEffect(SkillEffect se){
    this.effect = se;
  }

  public void setPower(int power){
    this.power = power;
  }

  public void ShowInfo(){
    super.ShowInfo();
    System.out.println("Skill Effect: " + this.effect);
    System.out.println("Power: " + this.power);
  }

  public abstract void activate(SummonedCharacter c);

  public abstract void deactivate(SummonedCharacter c);
}