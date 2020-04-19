package com.avatarduel.style;

import com.avatarduel.model.Game;
import com.avatarduel.model.card.SummonedCharacter;
import com.avatarduel.model.card.SummonedSkill;
import com.avatarduel.model.player.*;

public class GUIControl {
    private final int inField = 6;
    private FieldGroup p1Skill;
    private FieldGroup p1Char;
    private FieldGroup p2Char;
    private FieldGroup p2Skill;
    public GUIControl(FieldGroup p1Skill, FieldGroup p1Char, FieldGroup p2Char, FieldGroup p2Skill) {
        this.p1Skill = p1Skill;
        this.p1Char = p1Char;
        this.p2Char = p2Char;
        this.p2Skill = p2Skill;
    }

    public void renderGUI() {
        for (int i = 0; i < inField; i++) {
            p1Skill.updateAvatarField(i, Game.getGame().getPlayer(0).getSkills()[i]);
            p1Char.updateAvatarField(i, Game.getGame().getPlayer(0).getChar()[i]);
            p2Char.updateAvatarField(i, Game.getGame().getPlayer(1).getChar()[i]);
            p2Skill.updateAvatarField(i, Game.getGame().getPlayer(1).getSkills()[i]);
        }
    }
}