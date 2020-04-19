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
        for(int i=0;i<this.buttons.length;i++){
            this.buttons[i].setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event){
                    if(mode == 1){
                        //remove
                        game.sendCommand("");
                        game.getSkillButtons(ID).setVisibility(false);
                        game.getHandButtons(ID).setMode(1);
                        game.getHandButtons(ID).setVisibility(false);
                        mode = 0;
                    }
                    // else then the button is hidden 

                }
            });
        }
    }
}
