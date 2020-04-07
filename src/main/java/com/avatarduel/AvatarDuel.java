package com.avatarduel;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import com.avatarduel.style.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

import com.avatarduel.model.card.constant.Element;
import com.avatarduel.model.card.Land;
import com.avatarduel.util.CSVReader;


public class AvatarDuel extends Application {
  private static final String LAND_CSV_FILE_PATH = "card/data/land.csv";

  public void loadCards() throws IOException, URISyntaxException {
    File landCSVFile = new File(getClass().getResource(LAND_CSV_FILE_PATH).toURI());
    CSVReader landReader = new CSVReader(landCSVFile, "\t");
    landReader.setSkipHeader(true);
    List<String[]> landRows = landReader.read();
    for (String[] row : landRows) {
      Land l = new Land(row[1], row[3], Element.valueOf(row[2]));
//      l.ShowInfo();
    }
  }

  @Override
  public void start(Stage primaryStage) {
    Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
    primaryStage.setTitle("Avatar Duel");
    Group root = new Group();

    Text text = new Text("");
    root.getChildren().add(text);

//    AvatarPlayerCard c1 = new AvatarPlayerCard(Player p1);
//    AvatarPlayerCard c2 = new AvatarPlayerCard(Player p2);
    final double widthForHoveredCardComponent = screenBounds.getWidth() / 5;
    AvatarVBox hoveredCardComponent = new AvatarVBox(true, widthForHoveredCardComponent, screenBounds.getHeight());
    AvatarVBox arenaComponent = new AvatarVBox(false, screenBounds.getWidth() - widthForHoveredCardComponent, screenBounds.getHeight());

    AvatarStackPane hoveredCardPane = new AvatarStackPane(hoveredCardComponent, widthForHoveredCardComponent, screenBounds.getHeight(), Color.BLACK);
    AvatarStackPane battleArenaPane = new AvatarStackPane(arenaComponent, screenBounds.getWidth() - widthForHoveredCardComponent, screenBounds.getHeight(), Color.PURPLE);
    battleArenaPane.setTranslateX(widthForHoveredCardComponent);
    root.getChildren().addAll(hoveredCardPane, battleArenaPane);

    AvatarScene scene = new AvatarScene(root, screenBounds.getWidth(), screenBounds.getHeight());
    primaryStage.setScene(scene);
    primaryStage.show();

    try {
      this.loadCards();
    }
    catch (Exception e) {
      text.setText("Failed to load cards: " + e);
    }
  }

  public static void main(String[] args) {
    launch();
  }
}