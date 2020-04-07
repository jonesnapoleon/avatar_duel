package com.avatarduel.model;

import java.util.List;
import java.util.ArrayList;

import com.avatarduel.model.card.*;
import com.avatarduel.model.card.constant.CardState;
import com.avatarduel.model.card.constant.Element;
import com.avatarduel.model.player.Player;

public class Game{
    private static Game game = new Game();
    //private Player p1, p2;
    private int maxInField;
    private List<Player> players;
    private List<SummonedCharacter[]> playedCharacters;
    //private List<> playedSkill;
    private int turnId, phaseNum;
    private final String[] phase = {"Draw Phase", "Main Phase 1", "Battle Phase", "Main Phase 2", "End Phase"};

    private Game(){}

    public static Game getGame(){
        return game;
    }

    public void startGame(String a, List<Card> aC, String b, List<Card> bC){
        //this.p1 = new Player(a, aC);
        //this.p2 = new Player(b, bC);
        this.maxInField = 8;
        this.players = new ArrayList<Player>();
        this.players.add(new Player(a, aC));
        this.players.add(new Player(b, bC));
        this.playedCharacters = new ArrayList<SummonedCharacter[]>();
        this.playedCharacters.add(new SummonedCharacter[this.maxInField]);
        this.playedCharacters.add(new SummonedCharacter[this.maxInField]);
        for (int j = 0; j < this.maxInField; j++) {
            this.playedCharacters.get(0)[j] = new SummonedCharacter();
            this.playedCharacters.get(1)[j] = new SummonedCharacter();
        }
        this.turnId = 1;
        this.phaseNum = 0;
    }

    public void nextPhase(){
        this.phaseNum = (this.phaseNum + 1) % 5;
        if(this.phaseNum == 0)
            this.turnId = (this.turnId + 1) % 2;
        if(this.phaseNum==0)
            drawPhase();
        else if(this.phaseNum==1)
            mainPhase1();
        else if(this.phaseNum==2)
            battlePhase();
        else if(this.phaseNum==3)
            mainPhase2();
        else{
            // EndPhase here, add action if needed
            nextPhase();
        }
    }

    public String getPhaseInfo(){
        return this.phase[this.phaseNum];
    }

    public int getTurnInfo(){
        return this.turnId;
    }

    public void drawPhase() {
        players.get(this.turnId).moveDecksToHands(1);
        for (int i = 0; i < Element.numberElmt; i++) {
            players.get(this.turnId).setPower(i, players.get(this.turnId).getTotalPower(i));    
        }
        nextPhase();
    }

    public void mainPhase1() {
        
    }

    public void battlePhase() {
        
    }

    public void mainPhase2() {

    }

    public void attack(int attackerIdx, int defenderIdx){
        if (this.playedCharacters.get(this.turnId)[attackerIdx].getCardState() == CardState.ATTACK && 
            this.playedCharacters.get(this.turnId)[attackerIdx].getStateValue() >= this.playedCharacters.get((this.turnId + 1)%2)[defenderIdx].getStateValue()) {
                this.playedCharacters.get((this.turnId + 1)%2)[defenderIdx].removeCharacter();
                // Hapus Skill yang mengikuti
                if (this.playedCharacters.get((this.turnId + 1)%2)[defenderIdx].getCardState() == CardState.ATTACK) {
                    this.players.get((this.turnId + 1)%2).setHealth(this.players.get((this.turnId + 1)%2).getHealth() - 
                    (this.playedCharacters.get(this.turnId)[attackerIdx].getStateValue() - this.playedCharacters.get((this.turnId + 1)%2)[defenderIdx].getStateValue()));
                }
        } else {
            // Kalau langsung nyerang player lawan
        }
    }
}