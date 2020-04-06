package  com.avatarduel.model;

import com.avatarduel.model.card.*;
import com.avatarduel.model.player.Player;

public class Game{
    private static Game game = new Game();
    private Player p1, p2;
    private int maxInField

    private int turnId, phaseNum;
    private final String[] phase = {"Draw Phase", "Main Phase 1", "Battle Phase", "Main Phase 2", "End Phase"};

    private Game(){}

    public static Game getGame(){
        return game;
    }

    public void startGame(String a, List<Card> aC, String b, List<Card> bC){
        this.p1 = new Player(a, aC);
        this.p2 = new Player(b, bC);
        this.turnId = 1;
        this.phaseNum = 0;
    }

    public void nextPhase(){
        this.phaseNum = (this.phaseNum + 1)%5;
        if(this.phaseNum == 0 )
            this.turnId = (this.turnId+1)%2;
    }

    public String getPhaseInfo(){
        return this.phase[this.phaseNum];
    }

    public int getTurnInfo(){
        return this.turnId;
    }


}