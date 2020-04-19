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
    public FieldCharButtonGroup(int ID){
        super(6, "Select", ID);
        this.setVisibility(false);
        this.mode = 0;
        this.lastMode = 0;
        for(int i=0;i<this.buttons.length;i++){
            this.buttons[i].setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event){
                    if(mode == 1){
                        // battle idle phase
                        game.sendCommand("");
                        game.getCharButtons((ID+1)%2).setVisibility(true);
                        game.getCharButtons((ID+1)%2).setText("Select");
                        game.getCharButtons((ID+1)%2).setMode(6);
                        game.getCharButtons(ID).setVisibility(false);
                    }
                    else if(mode == 2){
                        //remove mode
                        game.sendCommand("");
                        game.getCharButtons((ID+1)%2).setVisibility(true);
                        game.getCharButtons((ID+1)%2).setText("Select");
                        game.getCharButtons(ID).setVisibility(false);
                    }
                    else if(mode == 3){
                        // append skill mode
                        game.sendCommand("");
                        game.getCharButtons(ID).setVisibility(false);
                        game.getHandButtons(ID).setVisibility(true);
                        game.getHandButtons(ID).setMode(1);
                    }
                    else if(mode == 4){
                        //change position mode
                        game.sendCommand("");
                    }
                    else if(mode ==5){
                        //place char mode
                        game.sendCommand("");
                        game.getCharButtons(ID).setVisibility(false);
                        game.getHandButtons(ID).setVisibility(true);
                        game.getHandButtons(ID).setMode(1);
                    }
                    else if(mode == 6){
                        // attacking enemy
                        game.sendCommand("");
                        game.getCharButtons((ID+1)%2).setVisibility(true);
                        game.getCharButtons((ID+1)%2).setText("Attack");
                        game.getCharButtons(ID).setVisibility(false);
                    }
                    // else if(mode == 7){
                    //     // place skill
                    // }
                }
            });
        }
    }
}
