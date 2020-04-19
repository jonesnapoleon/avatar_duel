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
    public HandButtonGroup(int cardInHand){
        super(cardInHand + 1, "Deploy");
        this.cardInHand = cardInHand;
        this.buttons[cardInHand].setText("Remove");
        this.mode = 1;
        this.lastMode = 1;
        for(Button b : this.buttons){
            b.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event){
                    if(mode == 1){
                        //deploy mode

                    }
                    // else then the button is hidden 

                }
            });
        }

        public void changeCardInHand(int diff){
            if(this.cardInHand + diff>=0 && this.cardInHand+diff<=10)
                this.cardInHand += diff;
        }
    }
}
