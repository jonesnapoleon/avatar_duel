package com.avatarduel.style;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HandButtonGroup extends ButtonGroup{
    private int cardInHand;
    public HandButtonGroup(int ID){
        super(8, "Deploy", ID);
        this.cardInHand = cardInHand;
        this.buttons[cardInHand].setText("Remove");
        this.mode = 1;
        this.lastMode = 1;
        for(int i=0;i<this.buttons.length-1;i++){
            this.buttons[i].setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event){
                    if(mode == 1){
                        //deploy char mode
                        game.sendCommand("");
                        game.getCharButtons(ID).setVisibility(true);
                        game.getCharButtons(ID).setText("Select");
                        // game.getCharButtons(ID).setMode(5);
                        game.getHandButtons(ID).setVisibility(false);
                        mode = 0;
                    }
                    // else if(mode == 2){
                    //     //deploy char mode
                    //     game.sendCommand("");
                    //     game.getCharButtons(ID).setVisibility(true);
                    //     game.getCharButtons(ID).setText("Select");
                    //     game.getCharButtons(ID).setMode(3);
                    //     game.getHandButtons(ID).setVisibility(false);
                    //     mode = 0;
                    // }
                    // else then the button is hidden 

                }
            });
        }
        this.buttons[this.buttons.length-1].setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                if(mode == 1){
                    //deploy char mode
                    game.sendCommand("");
                    game.getCharButtons(ID).setVisibility(true);
                    game.getCharButtons(ID).setText("Select");
                    // game.getCharButtons(ID).setMode(5);
                    game.getHandButtons(ID).setVisibility(false);
                    mode = 0;
                }
            }
        });
    }

    public void changeCardInHand(int diff){
        if(this.cardInHand + diff>=0 && this.cardInHand+diff<=10)
            this.cardInHand += diff;
    }
}
