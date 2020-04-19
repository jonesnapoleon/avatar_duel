package com.avatarduel.style;

//import com.avatarduel.model.player;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class ControllerButtonGroup extends HBox{
    public Button[] buttons;
    public ControllerButtonGroup(int num, String text){
        super();
        buttons = new Button[num];
//        System.out.println((this.buttons == null)? "IYA NULL" : "ENGGA");
//        System.out.println((this.buttons.length));

        for(int i=0;i<num;i++){
            this.buttons[i] = new Button(text);
            this.buttons[i].setMaxWidth(Double.MAX_VALUE);
//            this.getChildren().add(this.buttons[i]);
//            this.buttons[i].setOnAction(new EventHandler<ActionEvent>(){
//                @Override
//                public void handle(ActionEvent event){
//                    System.out.println("Hello Kitty");
//                }
//            });
        }
        this.setSpacing(10);
        this.setPadding(new Insets(0, 20, 10, 20));
        this.getChildren().addAll(this.buttons);
        setVisibility(false);
    }

    public void setVisibility(boolean flg){
        for(Button b : this.buttons){
            System.out.println((b == null)? "IYA NULL" : "ENGGA");
            b.setVisible(flg);
        }
    }
}