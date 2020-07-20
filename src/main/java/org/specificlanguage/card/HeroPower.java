package org.specificlanguage.card;

import org.specificlanguage.action.Action;
import org.specificlanguage.entity.Player;

public class HeroPower extends Card {

    public Action action;
    public String name;
    public String description;

    public HeroPower(Action action, String name, String description){

    }

    public static HeroPower getBasicPowerFromClass(CardClass cc, Player player){
        switch(cc){
            case DEMON_HUNTER:
                // return new HeroPower(new GiveHeroAttack(player), "Demon Claws", "Give your hero +1 attack."
            case DRUID:
                // return new HeroPower(new GiveHeroAttackAndArmor(player), "....", "Give your hero +1 attack and armor."
            case HUNTER:
                // return new HeroPower(new DealDamage(player.getGame().getOpponent(player), "....", "Deal 2 damage to your opponent."
            case MAGE:
                // return new HeroPower(new DealDamage(new Future(), "....", "Deal 1 damage."
            case PALADIN:
                // return new HeroPower(new Summon(1, 1, 1, 1, "Silver Hand Recruit"),
        }
    }

}
