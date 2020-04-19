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
import com.avatarduel.model.card.constant.Element;
import com.avatarduel.model.card.*;

public class AvatarField extends StackPane {
    private double width;
    private double height;
    private final String[] color = {};
    public AvatarField(final double width, final double height, final Color color){
        this.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setPrefHeight(height);
        this.setPrefWidth(width);
        this.setBorder(new Border(new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
        BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID,
        CornerRadii.EMPTY, new BorderWidths(2), Insets.EMPTY)));
        this.width = width;
        this.height = height;
        //System.out.println(this.getWidth());
    }

    public void activateCard(AvatarCharacterCard charCard, CardState state) {
        charCard.setField();
        charCard.setFieldRotate(state);
        this.getChildren().clear();
        this.getChildren().add(charCard);
    }

    public void activateCard(AvatarSkillCard skillCard) {
        skillCard.setField();
        this.getChildren().clear();
        this.getChildren().add(skillCard);
    }

    public void rotateCharCard() {
        ((AvatarCharacterCard)this.getChildren().get(0)).setFieldRotate();
    }

    public void updateCard(SummonedCharacter sc) {
        if (!sc.isOccupied()) {
            this.killCard();
        } else if (this.getChildren().isEmpty()) {
            this.activateCard(new AvatarCharacterCard(0, this.width*2/5, this.height*2/5, Color.web(this.color[sk.getSkill().getElement().ordinal()]), 
                        sc.getCharacter()), sc.getCardState());
        } else {
            ((AvatarCharacterCard)this.getChildren().get(0)).setFieldRotate(sc.getCardState());
            ((AvatarCharacterCard)this.getChildren().get(0)).setField();
        }
    }

    public void updateCard(SummonedSkill sk) {
        if (!sk.isOccupied()) {
            this.killCard();
        } else if (this.getChildren().isEmpty()) {
            this.activateCard(new AvatarSkillCard(0, this.width*2/5, this.height*2/5, Color.web(this.color[sk.getSkill().getElement().ordinal()]), sk.getSkill()));
        }
    }

    public void killCard() {
        this.getChildren().clear();
    }
}