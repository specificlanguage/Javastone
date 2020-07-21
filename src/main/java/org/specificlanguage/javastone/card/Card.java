package org.specificlanguage.javastone.card;

public abstract class Card {

    public CardClass cardClass;
    protected int mana;
    public String name;
    public Rarity rarity;
    public String id;

    abstract boolean playCard();

}
