package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.Board;
import org.specificlanguage.javastone.card.CardClass;
import org.specificlanguage.javastone.entity.Minion;
import org.specificlanguage.javastone.entity.Player;
import org.specificlanguage.javastone.event.GameEvent;

public class SummonAction implements Action {

    private int maxHealth;
    private int attack;
    private int cost;
    private String name;
    private Player player;
    private CardClass playerClass;
    private Minion minion;

    public SummonAction(int maxHealth, int attack, int cost, String name, Player player){
        this.maxHealth = maxHealth;
        this.attack = attack;
        this.cost = cost;
        this.name = name;
        this.player = player;
    }

    public SummonAction(int maxHealth, int attack, int cost, String name, Player player, CardClass cardClass){
        this(maxHealth, attack, cost, name, player);
        this.playerClass = cardClass;
    }

    /*
    public Summon(String cardID){
        //look up the card so we don't have to?
    }

     */

    public SummonAction(Minion minion){
        this.minion = minion;
    }

    public GameEvent createEvent(){
        // return new SummonEvent(this);
        return null;
    }




    @Override
    public boolean execute() {
        Minion minion = null;
        if (playerClass == null)
            playerClass = player.playerClass;
        if (this.minion == null)
            minion = new Minion(cost, attack, maxHealth, name, player, playerClass);
        else minion = this.minion;
        Board board = player.getGame().getBoard();
        board.summonMinion(player.getGame(), minion, player);
        return true;
    }
}
