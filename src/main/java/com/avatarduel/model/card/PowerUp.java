package com.avatarduel.model.card;
import com.avatarduel.model.card.constant.Element;
import com.avatarduel.model.card.constant.SkillEffect;

public class PowerUp extends Skill {

    public PowerUp(int id, String name, String description, Element element, int power, SkillEffect effect) {
        super(id, name, description, element, power, effect);
    }

    public void activate(SummonedCharacter c) {
        c.setPowerUp(true);
    }

    public void deactivate(SummonedCharacter c) {
        c.setPowerUp(false);
    }
}