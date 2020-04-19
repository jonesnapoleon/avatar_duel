package com.avatarduel.style;

//import com.avatarduel.model.player;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import com.avatarduel.model.card.Aura;
import com.avatarduel.model.card.Character;
import com.avatarduel.model.card.*;
import com.avatarduel.model.card.constant.CardState;
import com.avatarduel.model.card.constant.Element;
import com.avatarduel.model.card.constant.SkillEffect;

public class AvatarVBox extends VBox {
    public AvatarPlayerCard player1ProfileCard,player2ProfileCard;

    public AvatarVBox(final boolean isHoveredCardComponent, final double width, final double height){
        if(isHoveredCardComponent) {
            double heightForHoveredCard = height / 3;
            double widthForHoveredAndProfileCard = width - 20;
            double heightForProfileCard = (height - 2 * heightForHoveredCard) / 2 - 20;

            AvatarHoveredCard player1HoveredCard = new AvatarHoveredCard(new Rectangle( widthForHoveredAndProfileCard, heightForHoveredCard, Color.RED));
            AvatarHoveredCard player2HoveredCard = new AvatarHoveredCard(new Rectangle( widthForHoveredAndProfileCard, heightForHoveredCard, Color.RED));
            Aura character = new Aura(65, "Air Funnel", "Technique to create", Element.AIR, 7, SkillEffect.AURA, -4, 4);
            AvatarSkillCard a = new AvatarSkillCard(7, widthForHoveredAndProfileCard - 110, heightForHoveredCard - 20, Color.web("0x6cdfc5"), character);
            a.setInfo();
            player2HoveredCard.getChildren().addAll(a);

            player1ProfileCard = new AvatarPlayerCard(new Rectangle( widthForHoveredAndProfileCard,  heightForProfileCard, Color.YELLOW), "Player 1");
            player2ProfileCard = new AvatarPlayerCard(new Rectangle( widthForHoveredAndProfileCard, heightForProfileCard, Color.YELLOW), "Player 2");

            this.getChildren().addAll(player1HoveredCard, player1ProfileCard, player2ProfileCard, player2HoveredCard);
            this.setHeight(height);
            this.setWidth(width);
        }
        else {
            double heightForEachSection = height / 6;
            double widthForArena = width;

            AvatarHandsCard player1HandsCard = new AvatarHandsCard(new Rectangle(), widthForArena, heightForEachSection, Color.YELLOW);
            AvatarHandsCard player2HandsCard = new AvatarHandsCard(new Rectangle(), widthForArena, heightForEachSection, Color.RED);
            player1HandsCard.getChildren().add(new FieldGroup(10, widthForArena, heightForEachSection, Color.WHITE));
            player2HandsCard.getChildren().add(new FieldGroup(10, widthForArena, heightForEachSection, Color.WHITE));

            // Character charCard = new Character(65, "Air Funnel", "Technique to create", Element.AIR, 7, 4, 4);
            // AvatarCharacterCard ac = new AvatarCharacterCard(0, widthForArena/10, heightForEachSection, Color.web("0x6cdfc5"), charCard );
            // Character haha = new Character(65, "Air Funnel", "Technique to create", Element.AIR, 7, 4, 4);
            // AvatarCharacterCard acs = new AvatarCharacterCard(0, widthForArena/10, heightForEachSection, Color.web("0x6cdfc5"), charCard );
            // acs.setHand();
            //((FieldGroup)player1HandsCard.getChildren().get(1)).avatarField[0].activateCard(acs, CardState.ATTACK);

            AvatarStackPane player1SkillLayout = new AvatarStackPane(new Rectangle(), widthForArena, heightForEachSection, Color.ANTIQUEWHITE);
            AvatarStackPane player1CharLayout = new AvatarStackPane(new Rectangle(), widthForArena, heightForEachSection, Color.ANTIQUEWHITE);
            AvatarStackPane player2CharLayout = new AvatarStackPane(new Rectangle(), widthForArena, heightForEachSection, Color.DARKGREEN);
            AvatarStackPane player2SkillLayout = new AvatarStackPane(new Rectangle(), widthForArena, heightForEachSection, Color.DARKGREEN);
            player1SkillLayout.getChildren().addAll(new FieldGroup(6, widthForArena, heightForEachSection, Color.web("0x5f575f")));
            player1CharLayout.getChildren().addAll(new FieldGroup(6, widthForArena, heightForEachSection, Color.web("0x838691")));
            player2SkillLayout.getChildren().addAll(new FieldGroup(6, widthForArena, heightForEachSection, Color.web("0x5f575f")));
            player2CharLayout.getChildren().addAll(new FieldGroup(6, widthForArena, heightForEachSection, Color.web("0x838691")));
            //((AvatarField)((FieldGroup)(player1SkillLayout.getChildren().get(1))).getChildren().get(0)).activateCard(ac, CardState.ATTACK);
            // Character skillCard = new Character(65, "Air Funnel", "Technique to create", Element.AIR, 7, 4, 4);
            // AvatarCharacterCard a = new AvatarCharacterCard(0, /*widthForArena*2/30*/152, /*heightForEachSection - 20*/widthForArena*2/30, Color.web("0x6cdfc5"), skillCard);
            // ((AvatarField)player1SkillLayout.getChildren().get(0)).activateCharCard(a, CardState.ATTACK);
            // System.out.println(widthForArena/6);
            // System.out.println(((AvatarField)player1SkillLayout.getChildren().get(0)).getWidth());

            
            this.getChildren().addAll(player1HandsCard, player1SkillLayout, player1CharLayout, player2CharLayout, player2SkillLayout, player2HandsCard);
            this.setHeight(height);
            this.setWidth(width);
        }
    }

}
