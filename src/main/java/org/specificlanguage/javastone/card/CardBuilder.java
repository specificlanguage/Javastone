package org.specificlanguage.javastone.card;

import org.specificlanguage.javastone.action.Action;
import org.specificlanguage.javastone.entity.Player;
import org.specificlanguage.javastone.entity.attributes.Tribe;

public class CardBuilder {

    public enum CardType{
        SPELL, MINION, WEAPON, HERO, HERO_POWER;
    }

    Player player;
    Action action;
    CardType cardType;
    CardClass cardClass;
    int mana;
    int attack;
    int maxHealth;
    Tribe tribe;
    String imagePath;

    public CardBuilder(){}

    public CardBuilder(Player player){
        this.player = player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setAction(Action action){
        this.action = action;
    }

    public void setCardType(CardType cardType){
        this.cardType = cardType;
    }

    public void setCardClass(CardClass cardClass){
        this.cardClass = cardClass;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setMaxHealth(int maxHealth){
        this.maxHealth = maxHealth;
    }

    public void setTribe(Tribe tribe) {
        this.tribe = tribe;
    }

    public void setImagePath(String path){
        this.imagePath = path;
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
            case CardType.HERO_POWER:
                // create HeroPower "Card"
            }
        }

        return null; //TODO: once you make those cards, make the card that!
    }
    */
}
