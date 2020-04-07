package com.avatarduel.style;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public class AvatarHoveredCard extends StackPane {

    public AvatarHoveredCard(Node children){
        super(children);
        this.setAlignment(Pos.CENTER);
    }
}
