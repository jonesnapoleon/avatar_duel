package com.avatarduel.style;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
//import javafx.scene.layout.Background;
//import javafx.scene.layout.BackgroundFill;
//import javafx.scene.layout.CornerRadii;
//import javafx.scene.layout.StackPane;
//import javafx.scene.paint.Color;
//import com.avatarduel.model.player;

public class ButtonGroup extends HBox implements ObjectGroup{
    private Button[] buttons;
    public ButtonGroup(int num, String text){
        super();
        buttons = new Button[num];
//        System.out.println((this.buttons == null)? "IYA NULL" : "ENGGA");
//        System.out.println((this.buttons.length));

        for(int i=0;i<num;i++){
            this.buttons[i] = new Button(text);
//            System.out.println(this.buttons[i].getClass());
            this.buttons[i].setMaxWidth(Double.MAX_VALUE);
//            this.buttons[i].setText("Clicked");
            this.buttons[i].setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event){
//                    this.buttons[i].setText("Clicked");
//                    System.out.println(this.getClass());
                    System.out.println("Hello Kitty");
                    setVisibility(false);
                }
            });
        }
        this.setSpacing(10);
        this.setPadding(new Insets(0, 20, 10, 20));
        this.getChildren().addAll(this.buttons);
//        setVisibility(false);
    }

    @Override
    public void setVisibility(boolean flg){
        for(Button b : this.buttons){
            b.setVisible(flg);
        }
    }
}