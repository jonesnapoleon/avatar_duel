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

public class AvatarLandCard extends AvatarCard {
    private Land land;
    private double temp_width;
    private double temp_height;
    public AvatarLandCard(int spacing, final double width, final double height, final Color color, Land land) {
        super(spacing, width, height, color);
        this.land = land;
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
        Text nameText = new Text(land.getName());
        nameText.setStyle("-fx-font: 14 arial;");
        Text elementText = new Text(land.getElement().toString());
        elementText.setStyle("-fx-font: 14 arial;");
        cardName.setAlignment(nameText, Pos.CENTER_LEFT);
        cardName.setAlignment(elementText, Pos.CENTER_RIGHT);
        cardName.getChildren().addAll(nameText, elementText);
        cardName.setBorder(new Border(new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
        BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID,
        CornerRadii.EMPTY, new BorderWidths(2), Insets.EMPTY)));

        AvatarStackPane cardType = new AvatarStackPane(new Rectangle(), temp_width*3/4, temp_height*2/17, Color.web("0x6cdfc5"));
        Text typeText = new Text("[Land]");
        typeText.setStyle("-fx-font: 14 arial;");
        cardType.setAlignment(typeText, Pos.CENTER_RIGHT);
        cardType.getChildren().addAll(typeText);

        Image pict = new Image("file:///D:/Kuliah/OOP/avatar_duel/src/main/resources/com/avatarduel/card/image/land/Air Funnel.png", temp_width*3/4,  temp_height*8/17, false, true);
        ImageView img = new ImageView(pict);

        AvatarStackPane desc = new AvatarStackPane(new Rectangle(), temp_width*3/4, temp_height*6/17, Color.WHITE);
        Text description = new Text(land.getDesc());
        description.setStyle("-fx-font: 14 arial;");
        desc.setAlignment(description, Pos.TOP_LEFT);
        desc.setBorder(new Border(new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
        BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID,
        CornerRadii.EMPTY, new BorderWidths(2), Insets.EMPTY)));

        this.getChildren().addAll(cardName, cardType, img, desc);
    }

    public  void setField() {
        
    }

    public  void setHand() {

    }
}