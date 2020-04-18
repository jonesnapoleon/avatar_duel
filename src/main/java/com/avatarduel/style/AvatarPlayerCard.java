package com.avatarduel.style;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

/**TODO
 *  sambungin sama player somehow
 *  alternatif :    1. jadiin variable dalem player atau Player jadi variable dalem PlayerCard
 *                  2. bkin Player sama PlayerCard bisa saling komunikasi (termasuk antar PlayerCard)
 */
public class AvatarPlayerCard extends StackPane {
    private Text playertxt,hp,power,curPhase;
    private Button next;
    private int curAir,curWater,curFire,curEarth,curEnergy;//resource saat itu
    private int maxAir,maxWater,maxFire,maxEarth,maxEnergy;//max per turn
    private int curHP,maxHP;//urusan HP
    private final String[] phase = {"Draw Phase", "Main Phase", "Battle Phase", "End Phase"}; // nanti diisi pake phase-phase di back
    private int phaseNum;

    public AvatarPlayerCard(Node children,String player){
        super(children);
        maxHP = 80;
        curHP = 80;
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

        this.phaseNum = 0;

        playertxt = new Text(player);
        hp = new Text("HP "+curHP+"/"+maxHP);
        power = new Text("Air "+curAir+"/"+maxAir+"      Earth "+curEarth+"/"+curEarth+"   Energy "+curEnergy+"/"+maxEnergy+"    Fire "+curFire+"/"+maxFire+"    Water "+curWater+"/"+maxWater);
        curPhase = new Text(phase[phaseNum]);
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
        next.setOnAction(event -> nextTurn());
    }
    //SETTER (obvious sekali)
    private void setPowerTxt(){this.power.setText("Air "+curAir+"/"+maxAir+"      Earth "+curEarth+"/"+curEarth+"   Energy "+curEnergy+"/"+maxEnergy+"    Fire "+curFire+"/"+maxFire+"    Water "+curWater+"/"+maxWater); }
    private void setHPTxt(){this.hp.setText("HP "+curHP+"/"+maxHP);}
    public void setCurHP(int curHP){
        this.curHP = curHP;
        setHPTxt();
    }
    public void setCurAir(int curAir){
        this.curAir = curAir;
        setPowerTxt();
    }
    public void setCurEarth(int curEarth){
        this.curEarth = curEarth;
        setPowerTxt();
    }
    public void setCurEnergy(int curEnergy){
        this.curEnergy = curEnergy;
        setPowerTxt();
    }
    public void setCurFire(int curFire){
        this.curFire = curFire;
        setPowerTxt();
    }
    public void setCurWater(int curWater){
        this.curWater = curWater;
        setPowerTxt();
    }
    //setter current phase nanti dikaitin ke backend
    public void setCurPhase(String curPhase){this.curPhase.setText(curPhase);}

    //INCREMENTAL (dari kartu land)
    public void increaseMaxAir(){
        this.maxAir++;
        setPowerTxt();
    }
    public void increaseMaxEarth(){
        this.maxEarth++;
        setPowerTxt();
    }
    public void increaseMaxEnergy(){
        this.maxEnergy++;
        setPowerTxt();
    }
    public void increaseMaxFire(){
        this.maxFire++;
        setPowerTxt();
    }
    public void increaseMaxWater(){
        this.maxWater++;
        setPowerTxt();
    }

    /**
     * Fungsi dipanggil setiap mulai turn
     */
    public void startTurn(){
        setCurAir(maxAir);
        setCurEarth(maxEarth);
        setCurEnergy(maxEnergy);
        setCurFire(maxFire);
        setCurWater(maxWater);
        this.phaseNum=0;
        setCurPhase(phase[phaseNum]);
        /*TODO
            ada setter phase ke main phase
        */
        curPhase.setVisible(true);
        next.setVisible(true);

    }
    public void nextTurn(){
        this.phaseNum = (this.phaseNum + 1) % 4;
        setCurPhase(phase[phaseNum]);
        if(phaseNum == 3) this.endTurn();
    }
    public void endTurn(){
        /*TODO
            ada setter phase ke main phase
            ada setter turn ke player sebelah
        */
        next.setVisible(false);
        /*try{wait(1000);}
        catch(InterruptedException e){}
        startTurn();*/
    }
}
