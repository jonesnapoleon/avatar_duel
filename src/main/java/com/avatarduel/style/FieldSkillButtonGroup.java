package com.avatarduel.style;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class FieldSkillButtonGroup extends ButtonGroup{
    public FieldSkillButtonGroup(int ID){
        super(6, "Select", ID);
        this.setVisibility(false);
        this.mode = 0;
        this.lastMode = 0;
        for(Button b : this.buttons){
            b.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event){
                    if(mode == 1){
                        //remove


                    }
                    // then else mode == 0 when button hidden
                }
            });
        }
    }
}
