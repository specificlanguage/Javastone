package org.specificlanguage.javastone.entity;

import org.specificlanguage.javastone.HSGame;
import org.specificlanguage.javastone.action.DeathAction;
import org.specificlanguage.javastone.card.CardClass;
import org.specificlanguage.javastone.entity.attributes.Attribute;
import org.specificlanguage.javastone.listener.GameListener;

public class Minion extends Entity{

    public int cost;
    public String name;
    public CardClass cardClass;
    public String id;
    private GameListener[] listeners;

    public Minion(int cost, int attack, int maxHealth, String name, Player player, CardClass cardClass){
        super();
        setCost(cost);
        setAttack(attack);
        initHealth(maxHealth);
        this.name = name;
        this.playerControlled = player;
        this.cardClass = cardClass;
    }

    public Minion(int cost, int attack, int maxHealth, String name, Player player, CardClass cardClass, String id){
        this(cost, attack, maxHealth, name, player, cardClass);
        this.id = id;
    }

    public boolean setAttack(int attack){
        if (attack < 0)
            return false;
        this.attack = attack;
        return true;
    }

    private boolean setCost(int cost){
        if (cost < 0)
            return false;
        this.cost = cost;
        return true;
    }

    public boolean initHealth(int health){
        if (health <= 0)
            return false;
        this.health = health;
        this.maxHealth = health;
        return true;
    }

    public void addListeners(){
        game.addListeners(listeners);
    }

    private void deathSequence(){
        game.removeListeners(listeners);
        game.getBoard().removeMinion(this);
    }

    public void onDeath(){
        DeathAction deathAction = new DeathAction(this);
        deathSequence();
    }

}
