package org.specificlanguage.javastone.entity;

import org.specificlanguage.javastone.HSGame;
import org.specificlanguage.javastone.card.Card;
import org.specificlanguage.javastone.card.CardClass;
import org.specificlanguage.javastone.card.HeroPower;

public class Player extends Entity {

    private Card[] hand;
    private Card[] deck;
    public CardClass playerClass;
    public HeroPower heroPower;

    private Player(){
        this.hand = new Card[10];
        this.deck = new Card[30];
        initHealth(30);
        playerControlled = this;
    }

    public Player(CardClass cc){
        this();
        if (cc.equals(CardClass.DEATH_KNIGHT) || cc.equals(CardClass.DREAM) || cc.equals(CardClass.NEUTRAL)){
            throw new IllegalArgumentException();
        }
        this.playerClass = cc;
    }

    public Player(CardClass cc, int maxHealth){
        this(cc);
        initHealth(maxHealth);
    }

    private boolean initHealth(int maxHealth){
        if (maxHealth <= 0){
            throw new IllegalArgumentException();
        }
        this.maxHealth = maxHealth;
        return true;
    }

    public Player getOpponent() {
        try {
            return game.getOpponent(this);
        } catch(Exception e){
            return null;
        }
    }

    public boolean playHeroPower(){
        game.processEvent(heroPower.createEvent());
        return true;
    }

    public boolean drawCard(){
        // DrawCardEvent dcEvent = new DrawCardEvent(this);
        // game.processEvent(dcEvent);

        return true;
    }

    @Override
    public void onDeath() {
        // game needs to quit itself
    }
}
