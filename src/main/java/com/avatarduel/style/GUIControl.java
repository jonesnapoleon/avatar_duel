package com.avatarduel.style;

import com.avatarduel.model.Game;
import com.avatarduel.model.card.SummonedCharacter;
import com.avatarduel.model.card.SummonedSkill;
import com.avatarduel.model.player.*;

public class GUIControl {
    private final int inField = 6;
    private final int inHand = 10;
    private FieldGroup p1Hand;
    private FieldGroup p1Skill;
    private FieldGroup p1Char;
    private FieldGroup p2Char;
    private FieldGroup p2Skill;
    private FieldGroup p2Hand;
    public GUIControl(FieldGroup p1Hand, FieldGroup p1Skill, FieldGroup p1Char, FieldGroup p2Char, FieldGroup p2Skill, FieldGroup p2Hand) {
        this.p1Hand = p1Hand;
        this.p1Skill = p1Skill;
        this.p1Char = p1Char;
        this.p2Char = p2Char;
        this.p2Skill = p2Skill;
        this.p2Hand = p2Hand;
    }

    public void renderGUI() {
        for (int i = 0; i < inField; i++) {
            p1Skill.updateAvatarField(i, Game.getGame().getPlayer(0).getSkills()[i]);
            p1Char.updateAvatarField(i, Game.getGame().getPlayer(0).getChar()[i]);
            p2Char.updateAvatarField(i, Game.getGame().getPlayer(1).getChar()[i]);
            p2Skill.updateAvatarField(i, Game.getGame().getPlayer(1).getSkills()[i]);
        }

        for (int i = 0; i < inHand; i++) {
            if (i < Game.getGame().getPlayer(0).getCardsfromHand().size()) {
                p1Hand.updateAvatarField(i, Game.getGame().getPlayer(0).getCardsfromHand().get(i));
            } else {
                p1Hand.avatarField[i].getChildren().clear();
            }
            if (i < Game.getGame().getPlayer(1).getCardsfromHand().size()) {
                p2Hand.updateAvatarField(i, Game.getGame().getPlayer(1).getCardsfromHand().get(i));
            } else {
                p2Hand.avatarField[i].getChildren().clear();
            }
        }
    }
}