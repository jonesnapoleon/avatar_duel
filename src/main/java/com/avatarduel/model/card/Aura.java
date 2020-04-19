package com.avatarduel.model.card;
import com.avatarduel.model.card.constant.Element;
import com.avatarduel.model.card.constant.SkillEffect;

public class Aura extends Skill {
    private int attack;
    private int defense;

    public Aura(int id, String name, String description, Element element, int power, SkillEffect effect, int attack, int defense) {
        super(id, name, description, element, power, effect);
        this.attack = attack;
        this.defense = defense;
    }

    public void activate(SummonedCharacter c) {
        c.getCharacter().setAttack(c.getCharacter().getAttack() + this.attack);
        c.getCharacter().setDefense(c.getCharacter().getDefense() + this.defense);
    }

    public void deactivate(SummonedCharacter c) {
        c.getCharacter().setAttack(c.getCharacter().getAttack() - this.attack);
        c.getCharacter().setDefense(c.getCharacter().getDefense() - this.defense);
    }

    public int getAttack() {
        return this.attack;
    }

    public int getDefense() {
        return this.defense;
    }
}