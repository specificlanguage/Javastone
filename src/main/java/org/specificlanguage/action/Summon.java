package org.specificlanguage.action;

import org.specificlanguage.Board;
import org.specificlanguage.card.CardClass;
import org.specificlanguage.entity.Minion;
import org.specificlanguage.entity.Player;

public class Summon implements Action {

    private int maxHealth;
    private int attack;
    private int cost;
    private String name;
    private Player player;
    private CardClass playerClass;

    public Summon(int maxHealth, int attack, int cost, String name, Player player){
        this.maxHealth = maxHealth;
        this.attack = attack;
        this.cost = cost;
        this.name = name;
        this.player = player;
    }

    public Summon(int maxHealth, int attack, int cost, String name, Player player, CardClass cardClass){
        this(maxHealth, attack, cost, name, player);
        this.playerClass = cardClass;
    }

    /*
    public Summon(String cardID){
        //look up the card so we don't have to?
    }

     */

    @Override
    public boolean execute() {
        if (playerClass == null)
            playerClass = player.playerClass;
        Minion minion = new Minion(cost, attack, maxHealth, name, player, playerClass);
        Board board = player.getGame().getBoard();
        board.summonMinion(player.getGame(), minion, player);
        return true;
    }
}
