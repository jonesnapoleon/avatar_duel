package com.avatarduel.style;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

public class AvatarPlayerCard extends StackPane {
    private Text playertxt,hp,power,curPhase;
    private Button next;
    private int curAir,curWater,curFire,curEarth,curEnergy;//resource saat itu
    private int maxAir,maxWater,maxFire,maxEarth,maxEnergy;//max per turn
    private int curHP,maxHP;//urusan HP
    private String phases; // nanti diisi pake phase-phase di back

    public AvatarPlayerCard(Node children,String player){
        super(children);
        maxHP = 100;
        curHP = 100;
        maxAir = 0;
        curAir = 0;
        maxEnergy = 0;
        curEnergy = 0;
        maxFire = 0;
        curFire = 0;
        maxEarth = 0;
        curEarth = 0;
        maxWater = 0;
        curWater = 0;

        playertxt = new Text(player);
        hp = new Text("HP "+curHP+"/"+maxHP);
        power = new Text("Air "+curAir+"/"+maxAir+"      Earth "+curEarth+"/"+curEarth+"   Energy "+curEnergy+"/"+maxEnergy+"    Fire "+curFire+"/"+maxFire+"    Water "+curWater+"/"+maxWater);
        curPhase = new Text("Main Phase");
        next = new Button("Next Phase");
        this.setAlignment(playertxt ,Pos.TOP_LEFT);
        this.setAlignment(power ,Pos.CENTER);
        this.setAlignment(hp ,Pos.TOP_RIGHT);
        this.setAlignment(curPhase ,Pos.BOTTOM_LEFT);
        this.setAlignment(next ,Pos.BOTTOM_RIGHT);
        this.getChildren().addAll(playertxt,hp,power,curPhase,next);
        this.setMargin(playertxt, new Insets(12));
        this.setMargin(hp, new Insets(12));
        this.setMargin(curPhase, new Insets(12));
        this.setMargin(next, new Insets(12));
        //next.setVisible(false); //buat umpetin next sama phase
    }
    //SETTER (obvious sekali)
    public void setCurHP(int curHP){
        this.curHP = curHP;
    }
    public void setCurAir(int curAir){
        this.curAir = curAir;
    }
    public void setCurEarth(int curEarth){
        this.curEarth = curEarth;
    }
    public void setCurEnergy(int curEnergy){
        this.curEnergy = curEnergy;
    }
    public void setCurFire(int curFire){
        this.curFire = curFire;
    }
    public void setCurWater(int curWater){
        this.curWater = curWater;
    }
    //setter current phase nanti dikaitin ke backend
    public void setCurPhase(String curPhase){this.curPhase.setText(curPhase);}

    //INCREMENTAL (dari kartu land)
    public void increaseMaxAir(){this.maxAir++;}
    public void increaseMaxEarth(){this.maxEarth++;}
    public void increaseMaxEnergy(){this.maxEnergy++;}
    public void increaseMaxFire(){this.maxFire++;}
    public void increaseMaxWater(){this.maxWater++;}

    /**
     * Fungsi dipanggil setiap mulai turn
     */
    public void startTurn(){
        setCurAir(maxAir);
        setCurEarth(maxEarth);
        setCurEnergy(maxEnergy);
        setCurFire(maxFire);
        setCurWater(maxWater);
        curPhase.setText("Draw Phase");
        /*TODO
            ada setter phase ke main phase
        */
        curPhase.setVisible(true);
        next.setVisible(true);
    }

    public void endTurn(){
        /*TODO
            ada setter phase ke main phase
            ada setter turn ke player sebelah
        */
        curPhase.setVisible(false);
        next.setVisible(false);
    }
}
