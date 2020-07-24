package org.specificlanguage.javastone.entity;

import org.specificlanguage.javastone.card.Card;
import org.specificlanguage.javastone.card.CardClass;
import org.specificlanguage.javastone.card.HeroPower;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Player extends Entity {

    private LinkedList<Card> hand;
    private List<Card> deck;
    public CardClass playerClass;
    public HeroPower heroPower;
    public int armor;
    public int usableMana;
    public int maxMana;
    private int fatigue;

    private Player(){
        this.hand = new LinkedList<>();
        this.deck = new LinkedList<>();
        initHealth(30);
        playerControlled = this;
        maxMana = 0; usableMana = 0;
        fatigue = 0;
    }

    public Player(CardClass cc){
        this();
        if (cc.equals(CardClass.DEATH_KNIGHT) || cc.equals(CardClass.DREAM) || cc.equals(CardClass.NEUTRAL)){
            throw new IllegalArgumentException();
        }
        this.playerClass = cc;
    }

    public Player(CardClass cc, List<Card> deck){
        this(cc);
        this.deck = deck;
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

    @Override
    public void onDeath() {
        // game needs to quit itself
    }

    @Override
    public boolean damage(int damage) {
        int currentArmor = this.armor;
        if(armor > 0 && damage < armor){
            armor -= damage;
            return true;
        } else if (armor > 0 && damage > armor){
            armor = 0;
            damage -= currentArmor;
        }
        return super.damage(damage);
    }

    /*
    public pickTarget(){

    TODO: pick target

    }
     */

    public Card drawCard(){
        Random random = new Random();
        int cardIndex = random.nextInt(deck.size());
        Card card = deck.remove(cardIndex);
        hand.add(card);
        return card;
    }

    public List<Card> getDeck(){
        return deck;
    }

    public int getFatigue(){
        return fatigue;
    }

    public boolean incFatigue(){
        fatigue++;
        return true;
    }


}
