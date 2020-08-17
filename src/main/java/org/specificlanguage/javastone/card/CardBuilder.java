package org.specificlanguage.javastone.card;

import org.specificlanguage.javastone.action.GameAction;
import org.specificlanguage.javastone.entity.Player;
import org.specificlanguage.javastone.entity.attributes.Tribe;

public class CardBuilder {



    Player player;
    GameAction action;
    CardType cardType;
    CardClass cardClass;
    int mana;
    int attack;
    int maxHealth;
    Tribe tribe;
    String imagePath;
    String name;
    String flavor;
    String text;
    Rarity rarity;

    public CardBuilder(){}

    public CardBuilder(Player player){
        this.player = player;
    }

    public CardBuilder setPlayer(Player player) {
        this.player = player;
        return this;
    }

    public CardBuilder setAction(GameAction action){
        this.action = action;
        return this;
    }

    public CardBuilder setCardType(CardType cardType){
        this.cardType = cardType;
        return this;
    }

    public CardBuilder setCardClass(CardClass cardClass){
        this.cardClass = cardClass;
        return this;
    }

    public CardBuilder setMana(int mana) {
        this.mana = mana;
        return this;
    }

    public CardBuilder setAttack(int attack) {
        this.attack = attack;
        return this;
    }

    public CardBuilder setMaxHealth(int maxHealth){
        this.maxHealth = maxHealth;
        return this;
    }

    public CardBuilder setTribe(Tribe tribe) {
        this.tribe = tribe;
        return this;
    }

    public CardBuilder setImagePath(String path){
        this.imagePath = path;
        return this;
    }

    public CardBuilder setName(String name){
        this.name = name;
        return this;
    }

    public CardBuilder setFlavor(String flavor){
        this.flavor = flavor;
        return this;
    }

    public CardBuilder setText(String text) {
        this.text = text;
        return this;
    }

    public CardBuilder setRarity(Rarity rarity){
        this.rarity = rarity;
        return this;
    }

    /*
    public Card buildCard(){
        assert (player != null && mana >= 0 && cardType != null);

        check card repository and check it's a valid card

        switch(cardType) {
            case CardType.SPELL:
                // create Spell Card
            case CardType.MINION:
                assert (maxHealth > 0 && attack >= 0);
                // create Minion Card
            case CardType.HERO:
                // create Weapon CArd
            case CardType.WEAPON:
                // create Hero Card
            }
        }

        return null; //TODO: once you make those cards, make the card that!
    }
    */

    //TODO: create a card!

    public Card create(){
        return null;
    }
}
