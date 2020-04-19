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

public abstract class ButtonGroup extends HBox implements ObjectGroup{
    protected Button[] buttons;
    protected int mode, lastMode;

    public ButtonGroup(int num, String text){
        super();
        this.buttons = new Button[num];
        for(int i=0;i<num;i++){
           this.buttons[i] = new Button(text);
           this.buttons[i].setMaxWidth(Double.MAX_VALUE);
           this.buttons[i].toFront();
//            this.buttons[i].setText("Clicked");
//            System.out.println(this.buttons[i].getClass());
        }
        this.setSpacing(10);
        this.setPadding(new Insets(0, 20, 10, 20));
        this.getChildren().addAll(this.buttons);
//        System.out.println((this.buttons == null)? "IYA NULL" : "ENGGA");
//        System.out.println((this.buttons.length));
//        setVisibility(false);

//            this.buttons[i].setOnAction(new EventHandler<ActionEvent>(){
//                @Override
//                public void handle(ActionEvent event){
//                    if(mode==1){
////                        System.out.println("Hello Kitty");
//                        f1();
//                        mode = 2;
//                    }
//                    else{
////                        System.out.println("Hello Kitty");
//                        mode = 1;
//                    }
////                    this.buttons[i].setText("Clicked");
////                    System.out.println(this.getClass());
//                }
//            });
        }
        @Override
        public void setVisibility(boolean flg){
            for(Button b : this.buttons){
                b.setVisible(flg);
            }
            if(flg)
                this.mode = this.lastMode;
            else{
                this.lastMode = this.mode;
                this.mode = 0;
            }
        }
    }
//    public void f1(){
//        for(Button b : this.buttons){
////            b.setVisible(flg);
//            b.setText("tceleS");
////            b.setOnAction(new EventHandler<ActionEvent>(){
////                @Override
////                public void handle(ActionEvent event){
//////                    this.buttons[i].setText("Clicked");
//////                    System.out.println(this.getClass());
////                    System.out.println("Hello Kitik");
////                    f2();
//////                    setVisibility(false);
////                }
////            });
//        }
//    }
