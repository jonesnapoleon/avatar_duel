package com.avatarduel.style;

import com.avatarduel.model.player.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class AvatarVBox extends VBox {
    public AvatarVBox(final boolean isHoveredCardComponent, final double width, final double height){
        if(isHoveredCardComponent) {
            double heightForHoveredCard = height / 3;
            double widthForHoveredAndProfileCard = width - 20;
            double heightForProfileCard = (height - 2 * heightForHoveredCard) / 2 - 20;

            AvatarHoveredCard player1HoveredCard = new AvatarHoveredCard(new Rectangle( widthForHoveredAndProfileCard, heightForHoveredCard, Color.RED));
            AvatarHoveredCard player2HoveredCard = new AvatarHoveredCard(new Rectangle( widthForHoveredAndProfileCard, heightForHoveredCard, Color.RED));

            AvatarPlayerCard player1ProfileCard = new AvatarPlayerCard(new Rectangle( widthForHoveredAndProfileCard,  heightForProfileCard, Color.YELLOW));
            AvatarPlayerCard player2ProfileCard = new AvatarPlayerCard(new Rectangle( widthForHoveredAndProfileCard, heightForProfileCard, Color.YELLOW));

            this.getChildren().addAll(player1HoveredCard, player1ProfileCard, player2ProfileCard, player2HoveredCard);
            this.setHeight(height);
            this.setWidth(width);
        }
        else {
            this.getChildren().addAll(new Button("JONES"));
        }
    }

}
