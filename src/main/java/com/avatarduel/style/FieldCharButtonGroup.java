package com.avatarduel.style;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class FieldCharButtonGroup extends ButtonGroup{
    public FieldCharButtonGroup(){
        super(6, "Select");
        this.mode = 1;
        this.lastMode = 1;
        for(Button b : this.buttons){
            b.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event){
                    if(mode == 1){
                        //attack mode

                    }
                    else if(mode == 2){
                        //remove mode

                    }
                    else if(mode == 3){
                        // append skill mode
                        
                    }
                    else if(mode == 4){
                        //change position mode

                    }
                    else if(mode ==5){
                        //place char mode

                    }
                }
            });
        }
    }
}
