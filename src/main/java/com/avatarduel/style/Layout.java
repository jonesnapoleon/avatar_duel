package com.avatarduel.style;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Layout {
    private Group root;
    private Scene scene;
    private Text text;

    public Layout(Stage stage){
        this.root = new Group();
        Scene scene = new Scene(root, 1280, 720);
        stage.setTitle("Avatar Duel");
        stage.setScene(scene);
        stage.show();

        Text text = new Text();
        text.setText("Loading...");
        this.root.getChildren().add(text);
    }

    public void addText(String string){
        Text text = new Text();
        this.text.setText(string);
        // this.root.getChildren().add(text);
    }

}