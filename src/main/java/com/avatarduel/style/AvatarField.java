package com.avatarduel.style;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import javafx.scene.layout.*;
import com.avatarduel.model.card.constant.CardState;

public class AvatarField extends StackPane {
    public AvatarField(final double width, final double height, final Color color){
        this.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setPrefHeight(height);
        this.setPrefWidth(width);
        this.setBorder(new Border(new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
        BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID,
        CornerRadii.EMPTY, new BorderWidths(2), Insets.EMPTY)));
        //System.out.println(this.getWidth());
    }

    public void activateCharCard(AvatarCharacterCard charCard, CardState state) {
        //charCard.setFieldHorizontal();
        charCard.setField();
        if (state == CardState.DEFENSE) {
            charCard.setFieldRotate();      
        }
        this.getChildren().clear();
        this.getChildren().add(charCard);
    }

    public void rotateCharCard() {
        ((AvatarCharacterCard)this.getChildren().get(0)).setFieldRotate();
    }

    public void updateCard() {

    }

    public void killCard() {
        this.getChildren().clear();
    }

    public void activateSkillCard(AvatarSkillCard skillCard) {
        skillCard.setField();
        this.getChildren().clear();
        this.getChildren().add(skillCard);
    }
}