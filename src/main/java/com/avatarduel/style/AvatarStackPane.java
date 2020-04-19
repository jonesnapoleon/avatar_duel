package com.avatarduel.style;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class AvatarStackPane extends StackPane {
    public AvatarStackPane(Node children, final double width, final double height, final Color color){
        super(children);
        this.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setPrefHeight(height);
        this.setPrefWidth(width);
    }
}
