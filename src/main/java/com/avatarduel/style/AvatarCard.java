package com.avatarduel.style;

import javafx.scene.layout.VBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;

public abstract class AvatarCard extends VBox {
    public AvatarCard(int spacing, final double width, final double height, final Color color) {
        super(spacing);
        this.setAlignment(Pos.CENTER);
        this.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setPrefHeight(height);
        this.setPrefWidth(width);
    }

    public void closeCard() {

    }

    public abstract void setField();
    public abstract void setInfo();
    public abstract void setHand();
}