package com.avatarduel.style;

import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import com.avatarduel.model.card.SummonedCharacter;
import com.avatarduel.model.card.SummonedSkill;
import com.avatarduel.model.card.Card;

public class FieldGroup extends HBox {
    public AvatarField[] avatarField;
    public FieldGroup(int fieldCount, final double width, final double height, final Color color) {
        super(1);
        this.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setPrefHeight(height);
        this.setPrefWidth(width);
        this.avatarField = new AvatarField[fieldCount];
        for (int i = 0; i < fieldCount; i++) {
            this.avatarField[i] = new AvatarField(width/fieldCount, height, color);
            this.getChildren().add(this.avatarField[i]);
        }
        
    }
    public void updateAvatarField(int i, SummonedCharacter sc) {
        this.avatarField[i].updateCard(sc);
    }
    public void updateAvatarField(int i, SummonedSkill sk) {
        this.avatarField[i].updateCard(sk);
    }
    public void updateAvatarField(int i, Card card) {
        this.avatarField[i].updateCard(card);
    }
}