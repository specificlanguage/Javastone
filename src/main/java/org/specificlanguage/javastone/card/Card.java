package org.specificlanguage.javastone.card;

import org.specificlanguage.javastone.entity.Player;

public abstract class Card {

    public CardClass cardClass;
    public Player playerControlled;
    public int mana;
    public String name;
    public Rarity rarity;
    public String id;

    abstract boolean playCard();


}
