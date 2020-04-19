package com.avatarduel.style;

import com.avatarduel.model.card.Character;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class AvatarCharacterCard extends AvatarCard {
    private Character character;
    private double temp_width;
    private double temp_height;
    public AvatarCharacterCard(int spacing, final double width, final double height, final Color color, Character character) {
        super(spacing, width, height, color);
        this.character = character;
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

        AvatarStackPane cardName = new AvatarStackPane(new Rectangle(), temp_width*3/4, temp_height*2/17, Color.web("0xffcc77"));
        Text nameText = new Text(character.getName());
        Text elementText = new Text(character.getElement().toString());
        cardName.setAlignment(nameText, Pos.CENTER_LEFT);
        cardName.setAlignment(elementText, Pos.CENTER_RIGHT);
        cardName.getChildren().addAll(nameText, elementText);
        cardName.setBorder(new Border(new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
        BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID,
        CornerRadii.EMPTY, new BorderWidths(2), Insets.EMPTY)));

        AvatarStackPane cardType = new AvatarStackPane(new Rectangle(), temp_width*3/4, temp_height*2/17, Color.web("0xffcc77"));
        Text typeText = new Text("[Character]");
        cardType.setAlignment(typeText, Pos.CENTER_RIGHT);
        cardType.getChildren().addAll(typeText);

        Image pict = new Image("file:///D:/Kuliah/OOP/avatar_duel/src/main/resources/com/avatarduel/card/image/character/Katara.png", temp_width*3/4,  temp_height*8/17, false, true);
        ImageView img = new ImageView(pict);

        AvatarStackPane desc = new AvatarStackPane(new Rectangle(), temp_width*3/4, temp_height*6/17, Color.WHITE);
        Text description = new Text(character.getDesc());
        Text atk_def = new Text("ATK/" + character.getAttack() + " | " + "DEF/" + character.getDefense() + " | " + "POW/" + character.getPower());
        desc.setAlignment(description, Pos.TOP_LEFT);
        desc.setAlignment(atk_def, Pos.BOTTOM_RIGHT);
        desc.setBorder(new Border(new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
        BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID,
        CornerRadii.EMPTY, new BorderWidths(2), Insets.EMPTY)));
        desc.getChildren().addAll(description, atk_def);

        this.getChildren().addAll(cardName, cardType, img, desc);
    }

    public  void setField() {
        this.getChildren().clear();
        StackPane.setMargin(this, new Insets(10 , 75, 10, 75));
        Text name = new Text(this.character.getName());
        name.setStyle("-fx-font: 12 arial;");
        Text elementText = new Text(this.character.getElement().toString());
        elementText.setStyle("-fx-font: 12 arial;");
        Text atk = new Text("ATK/" + this.character.getAttack());
        atk.setStyle("-fx-font: 12 arial;");
        Text def = new Text("DEF/" + this.character.getDefense());
        def.setStyle("-fx-font: 12 arial;");
        Text pow = new Text("POW/" + this.character.getPower());

        pow.setStyle("-fx-font: 12 arial;");
        this.getChildren().addAll(name, elementText, atk, def, pow );
    }

    public void setFieldRotate() {
        if ((int)this.getRotate() == -90) {
            this.setRotate(0);
        } else {
            this.setRotate(-90);
        }
    }

    public  void setHand() {

    }
}