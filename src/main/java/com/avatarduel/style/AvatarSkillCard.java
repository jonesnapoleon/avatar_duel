package com.avatarduel.style;

import com.avatarduel.model.card.*;
import com.avatarduel.model.card.constant.SkillEffect;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class AvatarSkillCard extends AvatarCard {
    private Skill skill;
    private double temp_width;
    private double temp_height;
    public AvatarSkillCard(int spacing, final double width, final double height, final Color color, Skill skill) {
        super(spacing, width, height, color);
        this.skill = skill;
        this.temp_width = width;
        this.temp_height = height;
    }

    public void setInfo() {
        this.getChildren().clear();
        // Setup size and position
        StackPane.setMargin(this, new Insets(10 ,55, 10, 55));
        this.setPadding(new Insets(5, 10, 5, 10));
        this.setBorder(new Border(new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
        BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID,
        CornerRadii.EMPTY, new BorderWidths(2), Insets.EMPTY)));

        AvatarStackPane cardName = new AvatarStackPane(new Rectangle(), temp_width*3/4, temp_height*2/17, Color.web("0x6cdfc5"));
        Text nameText = new Text(skill.getName());
        nameText.setStyle("-fx-font: 14 arial;");
        Text elementText = new Text(skill.getElement().toString());
        elementText.setStyle("-fx-font: 14 arial;");
        cardName.setAlignment(nameText, Pos.CENTER_LEFT);
        cardName.setAlignment(elementText, Pos.CENTER_RIGHT);
        cardName.getChildren().addAll(nameText, elementText);
        cardName.setBorder(new Border(new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
        BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID,
        CornerRadii.EMPTY, new BorderWidths(2), Insets.EMPTY)));

        AvatarStackPane cardType = new AvatarStackPane(new Rectangle(), temp_width*3/4, temp_height*2/17, Color.web("0x6cdfc5"));
        Text skillType = new Text(this.skill.getEffect().toString());
        skillType.setStyle("-fx-font: 14 arial;");
        Text typeText = new Text("[Skill]");
        typeText.setStyle("-fx-font: 14 arial;");
        cardType.setAlignment(skillType, Pos.CENTER_LEFT);
        cardType.setAlignment(typeText, Pos.CENTER_RIGHT);
        cardType.getChildren().addAll(skillType, typeText);

        Image pict = new Image("file:///D:/Kuliah/OOP/avatar_duel/src/main/resources/com/avatarduel/card/image/skill/Air Funnel.png", temp_width*3/4,  temp_height*8/17, false, true);
        ImageView img = new ImageView(pict);

        AvatarStackPane desc = new AvatarStackPane(new Rectangle(), temp_width*3/4, temp_height*6/17, Color.WHITE);
        Text description = new Text(skill.getDesc());
        description.setStyle("-fx-font: 14 arial;");
        desc.setAlignment(description, Pos.TOP_LEFT);
        desc.setBorder(new Border(new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
        BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID,
        CornerRadii.EMPTY, new BorderWidths(2), Insets.EMPTY)));
        desc.getChildren().add(description);
        if (this.skill.getEffect() == SkillEffect.AURA) {
            Text atk_def = new Text("ATK/" + ((Aura)skill).getAttack() + " | " + "DEF/" + ((Aura)skill).getDefense() + " | " + "POW/" + skill.getPower());
            atk_def.setStyle("-fx-font: 14 arial;");
            desc.setAlignment(atk_def, Pos.BOTTOM_RIGHT);
            desc.getChildren().add(atk_def);
        }

        this.getChildren().addAll(cardName, cardType, img, desc);
    }

    public void setField() {
        this.getChildren().clear();
        StackPane.setMargin(this, new Insets(10 , 75, 10, 75));
        Text name = new Text(this.skill.getName());
        name.setStyle("-fx-font: 12 arial;");
        Text skillType = new Text(this.skill.getEffect().toString());
        skillType.setStyle("-fx-font: 12 arial;");
        Text elementText = new Text(skill.getElement().toString());
        elementText.setStyle("-fx-font: 12 arial;");
        this.getChildren().addAll(name, skillType, elementText);
        if (this.skill.getEffect() == SkillEffect.AURA) {
            Text atk = new Text("ATK/" + ((Aura)skill).getAttack());
            atk.setStyle("-fx-font: 12 arial;");
            Text def = new Text("DEF/" + ((Aura)skill).getDefense());
            def.setStyle("-fx-font: 12 arial;");
            Text pow = new Text("POW/" + skill.getPower());
            pow.setStyle("-fx-font: 12 arial;");
            this.getChildren().addAll(atk, def, pow);
        }
    }

    public  void setHand() {

    }
}