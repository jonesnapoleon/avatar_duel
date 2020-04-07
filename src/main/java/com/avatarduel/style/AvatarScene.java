package com.avatarduel.style;

import javafx.beans.DefaultProperty;
import javafx.beans.NamedArg;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


@DefaultProperty("root")
public class AvatarScene extends Scene{
    private static final Color color = Color.LIGHTPINK;

    public AvatarScene(@NamedArg("root") Parent root, double width, double height){
        super(root, width - 200, height - 100, color);
    }

}
