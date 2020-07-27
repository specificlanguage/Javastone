package org.specificlanguage.javastone.card;

import org.specificlanguage.javastone.entity.Player;
import org.specificlanguage.javastone.entity.attributes.Attribute;

import java.util.Arrays;
import java.util.List;

public abstract class Card {

    protected CardClass cardClass;
    protected Player playerControlled;
    protected int mana;
    protected String name;
    protected Rarity rarity;
    protected String id;
    protected int dbf;
    protected List<Attribute> attributes;

    abstract boolean playCard();
    abstract boolean isPlayable();

    public int getMana() {
        return mana;
    }

    public int getDbf(){
        return dbf;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setCardClass(CardClass cardClass) {
        this.cardClass = cardClass;
    }

    public void setPlayerControlled(Player player){
        this.playerControlled = player;
    }

    public String getName() {
        return name;
    }

    public CardClass getCardClass() {
        return cardClass;
    }

    public Player getPlayerControlled() {
        return playerControlled;
    }

    public String getId() {
        return id;
    }

    public void addAttributes(List<Attribute> attributes) {
        this.attributes.addAll(attributes);
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public boolean setDbf(int dbf) {
        if(dbf < 0)
            return false;
        // TODO: check dbf
        this.dbf = dbf;
        return true;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public boolean setId(String id) {
        //TODO: check ID
        this.id = id;
        return true;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }
}
