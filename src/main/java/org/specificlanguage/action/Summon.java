package org.specificlanguage.action;

import org.specificlanguage.Board;
import org.specificlanguage.entity.Minion;
import org.specificlanguage.entity.Player;

public class Summon implements Action {

    private int health;
    private int maxHealth;
    private int attack;
    private int cost;
    private String name;
    private Player player;

    public Summon(int health, int maxHealth, int attack, int cost, String name, Player player){
        this.health = health;
        this.maxHealth = maxHealth;
        this.attack = attack;
        this.cost = cost;
        this.name = name;
        this.player = player;
    }

    /*
    public Summon(String cardID){
        //look up the card so we don't have to?
    }

     */

    @Override
    public boolean execute() {
        Minion minion = new Minion(cost, attack, health, maxHealth, name, player, player.getClass());
        Board board = player.getGame().getBoard();
        board.summonMinion(player.getGame(), minion, player);
    }
}
