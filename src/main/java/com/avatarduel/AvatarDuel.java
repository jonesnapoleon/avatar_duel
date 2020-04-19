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
  private List<Card> deck1 = new ArrayList<Card>();
  private List<Card> deck2 = new ArrayList<Card>();

  public void loadCards() throws IOException, URISyntaxException {
    int charComp = 25; int skillComp = 20; int landComp = 15;
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
      deck1.add(new Land(Integer.parseInt(landRows.get(landShuffler.get(z))[0])*10, 
                landRows.get(landShuffler.get(z))[1], 
                landRows.get(landShuffler.get(z))[3], 
                Element.valueOf(landRows.get(landShuffler.get(z))[2])));
      deck2.add(new Land(Integer.parseInt(landRows.get(landShuffler.get(z))[0])*10 + 1, 
                landRows.get(landShuffler.get(z))[1], 
                landRows.get(landShuffler.get(z))[3], 
                Element.valueOf(landRows.get(landShuffler.get(z))[2])));
      idx++;
    }

    for (int z = 0; z < skillComp/2; z++) {
      deck1.add(new Aura(Integer.parseInt(skillRows.get(skillShuffler.get(z))[0])*10, 
                skillRows.get(skillShuffler.get(z))[1], 
                skillRows.get(skillShuffler.get(z))[3], 
                Element.valueOf(skillRows.get(skillShuffler.get(z))[2]),
                Integer.parseInt(skillRows.get(skillShuffler.get(z))[5]),
                SkillEffect.AURA, Integer.parseInt(skillRows.get(skillShuffler.get(z))[6]), 
                Integer.parseInt(skillRows.get(skillShuffler.get(z))[7])));
      deck2.add(new Aura(Integer.parseInt(skillRows.get(skillShuffler.get(z))[0])*10 + 1, 
                skillRows.get(skillShuffler.get(z))[1], 
                skillRows.get(skillShuffler.get(z))[3], 
                Element.valueOf(skillRows.get(skillShuffler.get(z))[2]),
                Integer.parseInt(skillRows.get(skillShuffler.get(z))[5]),
                SkillEffect.AURA, Integer.parseInt(skillRows.get(skillShuffler.get(z))[6]), 
                Integer.parseInt(skillRows.get(skillShuffler.get(z))[7])));
      idx++;
    }

    for (int z = 0; z < charComp; z++) {
      deck1.add(new Character(Integer.parseInt(charRows.get(charShuffler.get(z))[0])*10, 
                charRows.get(charShuffler.get(z))[1], 
                charRows.get(charShuffler.get(z))[3], 
                Element.valueOf(charRows.get(charShuffler.get(z))[2]),
                Integer.parseInt(charRows.get(charShuffler.get(z))[7]),
                Integer.parseInt(charRows.get(charShuffler.get(z))[5]), 
                Integer.parseInt(charRows.get(charShuffler.get(z))[6])));
      deck2.add(new Character(Integer.parseInt(charRows.get(charShuffler.get(z))[0])*10 + 1, 
                charRows.get(charShuffler.get(z))[1], 
                charRows.get(charShuffler.get(z))[3], 
                Element.valueOf(charRows.get(charShuffler.get(z))[2]),
                Integer.parseInt(charRows.get(charShuffler.get(z))[7]),
                Integer.parseInt(charRows.get(charShuffler.get(z))[5]), 
                Integer.parseInt(charRows.get(charShuffler.get(z))[6])));
      idx++;
    }

    for (int z = 0; z < skillComp/4; z++) {
      deck1.add(new PowerUp(idx*10, Element.values()[z] + " Power Up", "power up card", Element.values()[z], 2, SkillEffect.POWER_UP));
      deck2.add(new PowerUp(idx*10 + 1, Element.values()[z] + " Power Up", "power up card", Element.values()[z], 2, SkillEffect.POWER_UP));
      idx++;
    }

    for (int z = 0; z < skillComp/4; z++) {
      deck1.add(new Destroy(idx*10, Element.values()[z] + " Destroy", "destroy card", Element.values()[z], 2, SkillEffect.DESTROY));
      deck2.add(new Destroy(idx*10 + 1, Element.values()[z] + " Destroy", "destroy card", Element.values()[z], 2, SkillEffect.DESTROY));
      idx++;
    }
    /*
    System.out.println("Deck1");
    int i = 0;
    for (Card card : deck1) {
      card.ShowInfo();
      System.out.println();
      i++;
    }
    System.out.println("Total Card : " + i);

    System.out.println("Deck2");
    i = 0;
    for (Card card : deck2) {
      card.ShowInfo();
      System.out.println();
      i++;
    }
    System.out.println("Total Card : " + i);
    */
  }
  
  @Override
  public void start(Stage primaryStage) {
    Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
    primaryStage.setTitle("Avatar Duel");
    Group root = new Group();

    Text text = new Text("");
    root.getChildren().add(text);


    final double widthForHoveredCardComponent = screenBounds.getWidth() / 5;
    AvatarVBox hoveredCardComponent = new AvatarVBox(true, widthForHoveredCardComponent, screenBounds.getHeight());
    AvatarVBox arenaComponent = new AvatarVBox(false, screenBounds.getWidth() - widthForHoveredCardComponent, screenBounds.getHeight());

//    ButtonGroup fieldButton = new ButtonGroup(6, "Select");
//    ButtonGroup fieldButton2 = new ButtonGroup(6, "Select");

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
      //text.setText("Failed to load cards: " + e);
    }
  }

  public static void main(String[] args) {
    launch();
  }
}