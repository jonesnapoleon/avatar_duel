package com.avatarduel.style;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class KillButton {
    public AvatarField af;
    public Button kill;
    public KillButton(AvatarField af) {
        this.kill = new Button("kill");
        this.af = af;
        this.kill.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
//                    this.buttons[i].setText("Clicked");
//                    System.out.println(this.getClass());
                //System.out.println("gilaaaaaaaaa");
                af.rotateCharCard();
            }
        });
    }
}