package com.avatarduel.style;

import javafx.beans.DefaultProperty;
import javafx.beans.NamedArg;
import javafx.scene.Parent;
import javafx.scene.Scene;


@DefaultProperty("root")
public class AvatarScene extends Scene{
    public AvatarScene(@NamedArg("root") Parent root, double width, double height){
        super(root, width - 200, height - 100);
    }

}
