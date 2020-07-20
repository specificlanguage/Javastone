package org.specificlanguage.entity;

import org.specificlanguage.HSGame;
import org.specificlanguage.card.Card;
import org.specificlanguage.card.CardClass;
import org.specificlanguage.card.HeroPower;

public class Player {

    public int health;
    public int maxHealth;
    private HSGame game;
    private Card[] cards;
    protected CardClass playerClass;
    public HeroPower heroPower;

    private Player(){
        this.cards = new Card[10];
        initHealth(30);
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

    public void setGame(HSGame game) {
        this.game = game;
    }

    public HSGame getGame(){
        return game;
    }

    public Player getOpponent() throws Exception {
        if (this.game == null)
            throw new Exception("Game not assigned to player");
        return getGame().getOpponent(this);
    }

}
