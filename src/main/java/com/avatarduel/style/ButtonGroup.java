package com.avatarduel.style;


import com.avatarduel.model.Game;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public abstract class ButtonGroup extends HBox implements ObjectGroup{
    protected Button[] buttons;
    protected int mode, lastMode;
    protected Game game = Game.getGame();
    protected int ID;

    public ButtonGroup(int num, String text, int ID){
        super();
        this.ID = ID;
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
    }

    public int getID(){
        return this.ID;
    }

    public void setMode(int mode){
        this.mode = mode;
    }

    @Override
    public void setVisibility(boolean flg){
        for(Button b : this.buttons){
            b.setVisible(flg);
        }
        if(flg){
            this.mode = this.lastMode;
            this.lastMode = 0;
        }
        else{
            this.lastMode = this.mode;
            this.mode = 0;
        }
    }

    public void setText(String text){
        for(Button b : this.buttons)
            b.setText(text);
    }
}
