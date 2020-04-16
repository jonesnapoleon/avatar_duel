package com.avatarduel;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
import com.avatarduel.model.card.constant.SkillEffect;
import com.avatarduel.model.card.*;
import com.avatarduel.model.card.Character;
import com.avatarduel.util.CSVReader;


public class AvatarDuel extends Application {
  
  private static final String LAND_CSV_FILE_PATH = "card/data/land.csv";
  private static final String SKILL_CSV_FILE_PATH = "card/data/skill_aura.csv";
  private static final String CHAR_CSV_FILE_PATH = "card/data/character.csv";

  public void loadCards() throws IOException, URISyntaxException {
    int charComp = 30; int skillComp = 15; int landComp = 15;
    List<Integer> charShuffler, skillShuffler, landShuffler; 
    int idx = 1;

    File landCSVFile = new File(getClass().getResource(LAND_CSV_FILE_PATH).toURI());
    CSVReader landReader = new CSVReader(landCSVFile, "\t");
    landReader.setSkipHeader(true);
    List<String[]> landRows = landReader.read();
    landShuffler = new ArrayList<Integer>();
    for (int j = 0; j < landRows.size(); j++) {
      landShuffler.add(j);
    }
    Collections.shuffle(landShuffler);

    File skillCSVFile = new File(getClass().getResource(SKILL_CSV_FILE_PATH).toURI());
    CSVReader skillReader = new CSVReader(skillCSVFile, "\t");
    skillReader.setSkipHeader(true);
    List<String[]> skillRows = skillReader.read();
    skillShuffler = new ArrayList<Integer>();
    for (int j = 0; j < skillRows.size(); j++) {
      skillShuffler.add(j);
    }
    Collections.shuffle(skillShuffler);

    File charCSVFile = new File(getClass().getResource(CHAR_CSV_FILE_PATH).toURI());
    CSVReader charReader = new CSVReader(charCSVFile, "\t");
    charReader.setSkipHeader(true);
    List<String[]> charRows = charReader.read();
    charShuffler = new ArrayList<Integer>();
    for (int j = 0; j < charRows.size(); j++) {
      charShuffler.add(j);
    }
    Collections.shuffle(charShuffler);

    for (int z = 0; z < landComp; z++) {
      Land l = new Land(Integer.parseInt(landRows.get(landShuffler.get(z))[0]), 
                        landRows.get(landShuffler.get(z))[1], 
                        landRows.get(landShuffler.get(z))[3], 
                        Element.valueOf(landRows.get(landShuffler.get(z))[2]));
      idx++;
    }

    for (int z = 0; z < skillComp; z++) {
      Aura l = new Aura(Integer.parseInt(landRows.get(landShuffler.get(z))[0]), 
                        landRows.get(landShuffler.get(z))[1], 
                        landRows.get(landShuffler.get(z))[3], 
                        Element.valueOf(landRows.get(landShuffler.get(z))[2]),
                        Integer.parseInt(skillRows.get(skillShuffler.get(z))[5]),
                        SkillEffect.AURA, Integer.parseInt(skillRows.get(skillShuffler.get(z))[6]), 
                        Integer.parseInt(skillRows.get(skillShuffler.get(z))[7]));
      idx++;
    }
  }
  
  @Override
  public void start(Stage primaryStage) {
    //Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
    //primaryStage.setTitle("Avatar Duel");
    //Group root = new Group();

    //Text text = new Text("");
    //root.getChildren().add(text);

//    AvatarPlayerCard c1 = new AvatarPlayerCard(Player p1);
//    AvatarPlayerCard c2 = new AvatarPlayerCard(Player p2);
    //final double widthForHoveredCardComponent = screenBounds.getWidth() / 5;
    //AvatarVBox hoveredCardComponent = new AvatarVBox(true, widthForHoveredCardComponent, screenBounds.getHeight());
    //AvatarVBox arenaComponent = new AvatarVBox(false, screenBounds.getWidth() - widthForHoveredCardComponent, screenBounds.getHeight());

    //AvatarStackPane hoveredCardPane = new AvatarStackPane(hoveredCardComponent, widthForHoveredCardComponent, screenBounds.getHeight(), Color.BLACK);
    //AvatarStackPane battleArenaPane = new AvatarStackPane(arenaComponent, screenBounds.getWidth() - widthForHoveredCardComponent, screenBounds.getHeight(), Color.PURPLE);
    //battleArenaPane.setTranslateX(widthForHoveredCardComponent);
    //root.getChildren().addAll(hoveredCardPane, battleArenaPane);

    //AvatarScene scene = new AvatarScene(root, screenBounds.getWidth(), screenBounds.getHeight());
    //primaryStage.setScene(scene);
    //primaryStage.show();

    try {
      this.loadCards();
    }
    catch (Exception e) {
      //text.setText("Failed to load cards: " + e);
    }
  }

  public static void main(String[] args) {
    launch();
  }
}