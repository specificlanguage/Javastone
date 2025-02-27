package org.specificlanguage.javastone.card;

import org.specificlanguage.javastone.action.*;
import org.specificlanguage.javastone.entity.Entity;
import org.specificlanguage.javastone.entity.Filter;
import org.specificlanguage.javastone.entity.Future;
import org.specificlanguage.javastone.entity.Player;

public class HeroPower<T extends GameAction> extends Card {

    private GameAction action;
    private String name;
    private String description;
    private boolean playable;
    private int mana;

    public HeroPower(GameAction action, String name, String description, int mana){
        this.action = action;
        this.name = name;
        this.description = description;
        this.playable = true;
        this.mana = mana;
    }


    public static HeroPower getBasicPowerFromClass(CardClass cc, Player player){
        switch(cc){
            /*
            case DEMON_HUNTER:
                // return new HeroPower(new GiveHeroAttack(player), "Demon Claws", "Give your hero +1 attack.");
            case DRUID:
                // hpaction = new CompoundAction(new GiveHeroAttack(player), new Armor(2, player));
                // return new HeroPower(hpaction, "....", "Give your hero +1 attack and armor.");
                */
            case HUNTER:
                return new HeroPower(DamageAction.create(player.getOpponent(), 2, player, CardType.HERO_POWER),
                        "Steady Shot", "Deal 2 damage", 2);
            case MAGE:
                return new HeroPower(DamageAction.create(new Future(), 1, player, CardType.HERO_POWER),
                        "Fireburst", "Deal 1 damage", 2);
                /*
            case PALADIN:
                return new HeroPower(new SummonAction(1, 1, 1, "Silver Hand Recruit",
                        player, player, CardClass.PALADIN), "Reinforce", "Summon a 1/1 Silver Hand Recruit.", 2);
                        */
            case PRIEST:
                return new HeroPower(HealAction.create(new Future(), 2, player, Filter.NO_FILTER),
                        "Lesser Heal", "Restore 2 health", 2);
                /*
            case ROGUE:
                // return new HeroPower(new Equip(1, 2, player),
            case SHAMAN:
                // return new HeroPower(new SummonTotem(player), "...."  )
            case WARRIOR:
                return new HeroPower(new ArmorAction(player, 2), "Armor Up!", "Gain 2 Armor.", 2);
            case WARLOCK:
                return new HeroPower(new CompoundAction(player, new DamageAction(player, player, 2),
                        new DrawCardAction(player, 1)), "Life Tap",
                        "Take 2 damage and draw a card.", 2);
            default:
                // return null; // literally can't */
        }
        return null;
    }

    @Override
    public boolean playCard() {
        Entity caster = action.getCaster();
        if (!(caster instanceof Player)){
            // find better way to do this?
            throw new IllegalArgumentException();
        }

        Player player = (Player) caster;
        if (player.getUsableMana() < mana){
            return false;
        }
        
        // player.getGame().processEvent(new HeroPowerEvent(this));
        player.useMana(mana);
        playable = false;
        this.action.cast();
        return true;
    }

    public boolean isPlayable(){
        return true;
    }
}
