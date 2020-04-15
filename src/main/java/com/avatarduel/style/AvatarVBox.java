package com.avatarduel.style;

//import com.avatarduel.model.player;
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
            double heightForEachSection = height / 6 - 10;
            double widthForArena = 8 * width / 23;

//            AvatarCard player1 = new AvatarCard();

            AvatarHandsCard player1HandsCard = new AvatarHandsCard(new Rectangle(), widthForArena, heightForEachSection, Color.YELLOW);
            AvatarHandsCard player2HandsCard = new AvatarHandsCard(new Rectangle(), widthForArena, heightForEachSection, Color.RED);

            AvatarArenaLayout player1Layout = new AvatarArenaLayout(new Rectangle(), widthForArena, 2 * heightForEachSection, Color.ANTIQUEWHITE);
            AvatarArenaLayout player2Layout = new AvatarArenaLayout(new Rectangle(), widthForArena, 2 * heightForEachSection, Color.DARKGREEN);

            AvatarCard a = new AvatarCard(new Rectangle(),widthForArena ,heightForEachSection,Color.BLUE);
            AvatarCard b = new AvatarCard(new Rectangle(),widthForArena ,heightForEachSection,Color.VIOLET);
            this.getChildren().addAll(player1HandsCard, player1Layout, player2Layout, player2HandsCard);
            this.setHeight(height);
            this.setWidth(width);
            this.getChildren().addAll(a,b);
        }
    }

}
