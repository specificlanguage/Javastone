package org.specificlanguage.entity;

import org.specificlanguage.HSGame;
import org.specificlanguage.card.Card;
import org.specificlanguage.card.CardClass;

public class Player {

    public int health;
    public int maxHealth;
    public HSGame game;
    public Card[] cards;
    protected CardClass playerClass;

    public Player(){
        this.cards = new Card[10];
        int health = 30;
        int maxHealth = 30;
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
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

}
