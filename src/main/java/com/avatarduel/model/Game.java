package com.avatarduel.model;

import java.util.List;
import java.util.ArrayList;

import com.avatarduel.ErrorClass;
import com.avatarduel.model.card.*;
import com.avatarduel.model.card.constant.CardState;
import com.avatarduel.model.card.constant.Element;
import com.avatarduel.model.player.Player;
import com.avatarduel.style.*;

public class Game{
    private static Game game = new Game();
    private int maxInField, maxInHand;
    private List<Player> players;
    private int turnId, phaseNum;
    //private final String[] phase = {"Draw Phase", "Main Phase 1", "Battle Phase", "Main Phase 2", "End Phase"};
    private String command[];
    private ArrayList<HandButtonGroup> handButtons;
    private ArrayList<FieldSkillButtonGroup> skillButtons;
    private ArrayList<FieldCharButtonGroup> charButtons;

    private Game(){}

    public static Game getGame(){
        return game;
    }

    public void startGame(String a, List<Card> aC, String b, List<Card> bC, int numOfCardsInField){
        this.maxInField = 6;
        this.maxInHand = 10;
        this.players = new ArrayList<Player>();
        this.players.add(new Player(a, aC, numOfCardsInField));
        this.players.add(new Player(b, bC, numOfCardsInField));
        this.turnId = 0;
        this.phaseNum = 0;
    }

    public void addSkillButtons(FieldSkillButtonGroup skillButtons){
        this.skillButtons.add(skillButtons);
    }

    public void addCharButtons(FieldCharButtonGroup charButtons){
        this.charButtons.add(charButtons);
    }

    public void addHandButtons(HandButtonGroup handButtons){
        this.handButtons.add(handButtons);
    }

    public FieldSkillButtonGroup getSkillButtons(int ID){
        for(FieldSkillButtonGroup b : skillButtons){
            if(b.getID()==ID)
                return b;
        }
        return null;
    }

    public FieldCharButtonGroup getCharButtons(int ID){
        for(FieldCharButtonGroup b : charButtons){
            if(b.getID()==ID)
                return b;
        }
        return null;
    }

    public HandButtonGroup getHandButtons(int ID){
        for(HandButtonGroup b : handButtons){
            if(b.getID()==ID)
                return b;
        }
        return null;
    }

    public void sendCommand(String cmd){
        this.command = cmd.split(" ");
        this.handlerEvent();
    }

    public void handlerEvent(){
        if(this.command[0] == "next")
            nextPhase();
        else if(this.command[0] == "attack"){
            // Rincian apa attack apa gitu
            /*
                keterangan
                    idx : index field musuh

            */
            // fungsi buat change interface/tampilan ke select enemy char
        }

        else if(this.command[0] == "deploy"){
            // fungsi buat change interface/tampilan ke select field buat char sendiri
            
        }
        else if(this.command[0] == "changepos"){
            // fungsi ubah posisi kartu di field
            // fungsi flip tampilan kartu di field
            //this.players.get(this.turnId).getChar()[idx].rotate();
            // render
        }
        else if (this.command[0] == "select"){
            if(this.command[1] == "attack"){
                //this.players.get(this.turnId).killChar(idx);
                // render
            }
            else if(this.command[1] == "remove"){
                if (this.command[2] == "char") {
                    //this.players.get(this.turnId).killChar(idx);
                    // render
                } else if (this.command[2] == "skill") {
                    //this.players.get(this.turnId).removeSkill(idx);
                    // render
                }
            }
            else if(this.command[1]== "deploy"){
                if(this.command[2] == "char"){
                    //this.players.get(this.turnId).moveCharToField(idx, cardId, cardState);
                    // render
                }
                else if (this.command[2] == "skill"){
                    //this.players.get(this.turnId).moveCharToField(idx, cardId, cardState);
                    // render
                }
                else if (this.command[2] == "land") {
                    //this.players.get(this.turnId).playLandCard(cardId);
                    // render
                }
            }
        }
    }
    
    public void nextPhase(){
        // buat change state di back, tulisan state di field, sekaligus add Function front buat change/tampilan interface
        this.phaseNum = (this.phaseNum + 1) % 5;
        if(this.phaseNum == 0)
            this.turnId = (this.turnId + 1) % 2;
        if(this.phaseNum==0)
            drawPhase();
        else if(this.phaseNum==1) {}
            //mainPhase1();
        else if(this.phaseNum==2) {}
            //battlePhase();
        else if(this.phaseNum==3) {}
            //mainPhase2();
        else{
            // EndPhase here, add action if needed
            nextPhase();
        }
    }
    
    // private void setErrResponse(String errCode, String msg){
    //     this.response[0] = errCode;
    //     this.response[1] = msg;
    // }

    // private void setNormalResponse(){
    //     this.response[0] = "200";
    // }

    

    public void drawPhase() {
        players.get(this.turnId).moveDecksToHands(1);
        for (int i = 0; i < Element.numberElmt; i++) {
            players.get(this.turnId).setPower(i, players.get(this.turnId).getTotalPower(i));    
        }
        nextPhase();
    }

    // public String getPhaseInfo(){
    //     return this.phase[this.phaseNum];
    // }

    // public int getTurnInfo(){
    //     return this.turnId;
    // }

    public Player getPlayer(int i) {
        return this.players.get(i);
    }
    
}