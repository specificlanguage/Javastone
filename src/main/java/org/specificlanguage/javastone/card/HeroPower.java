package org.specificlanguage.javastone.card;

import org.specificlanguage.javastone.HSGame;
import org.specificlanguage.javastone.action.*;
import org.specificlanguage.javastone.entity.Entity;
import org.specificlanguage.javastone.entity.Future;
import org.specificlanguage.javastone.entity.Player;
import org.specificlanguage.javastone.event.GameEvent;

import java.util.Objects;

public class HeroPower extends Card {

    private class HeroPowerEvent implements GameEvent {

        private final HeroPower hp;
        public HeroPowerEvent(HeroPower hp) {
            this.hp = Objects.requireNonNull(hp);
        }
        public HeroPower getHeroPower(){
            return this.hp;
        }
        public Action getAction(){
            return hp.action;
        }

    }

    public Action action;
    public String name;
    public String description;
    public boolean playable;
    public int mana;

    public HeroPower(Action action, String name, String description, int mana){
        this.action = action;
        this.name = name;
        this.description = description;
        this.playable = true;
        this.mana = mana;
    }

    public static HeroPower getBasicPowerFromClass(CardClass cc, Player player){
        switch(cc){
            case DEMON_HUNTER:
                // return new HeroPower(new GiveHeroAttack(player), "Demon Claws", "Give your hero +1 attack.");
            case DRUID:
                // hpaction = new CompoundAction(new GiveHeroAttack(player), new Armor(2, player));
                // return new HeroPower(hpaction, "....", "Give your hero +1 attack and armor.");
            case HUNTER:
                return new HeroPower(new DamageAction(player.getOpponent(), player, 2), "Steady Shot",
                        "Deal 2 damage to the enemy hero.", 2);
            case MAGE:
                return new HeroPower(new DamageAction(player, new Future(), 1), "Fireblast",
                        "Deal 1 damage.", 2);
            case PALADIN:
                return new HeroPower(new SummonAction(1, 1, 1, "Silver Hand Recruit",
                        player, player, CardClass.PALADIN), "Reinforce", "Summon a 1/1 Silver Hand Recruit.", 2);
            case PRIEST:
                return new HeroPower(new HealAction(player, new Future(), 2), "Lesser Heal",
                        "Restore 2 Health", 2);
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
                // return null; // literally can't
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
        
        player.getGame().processEvent(new HeroPowerEvent(this));
        player.useMana(mana);
        playable = false;
        this.action.execute(); // will process its own event
        return true;
    }

    public GameEvent createEvent(){
        return new HeroPowerEvent(this);
    }

    public boolean isPlayable(){
        return true;
    }
}
