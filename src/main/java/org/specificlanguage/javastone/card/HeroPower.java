package org.specificlanguage.javastone.card;

import org.specificlanguage.javastone.HSGame;
import org.specificlanguage.javastone.action.Action;
import org.specificlanguage.javastone.action.DamageAction;
import org.specificlanguage.javastone.action.SummonAction;
import org.specificlanguage.javastone.entity.Future;
import org.specificlanguage.javastone.entity.Player;
import org.specificlanguage.javastone.event.GameEvent;

import java.util.Objects;

public class HeroPower extends Card {

    public Action action;
    public String name;
    public String description;
    public boolean playable;
    private Player player;

    public HeroPower(Action action, String name, String description){
        this.action = action;
        this.name = name;
        this.description = description;
        this.playable = true;
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
                        "Deal 2 damage to the enemy hero.");
                // return new HeroPower(new DealDamage(2, player.getGame().getOpponent(player),
                // "....", "Deal 2 damage to your opponent.");
            case MAGE:
                return new HeroPower(new DamageAction(new Future(), player, 1), "Fireblast",
                        "Deal 1 damage.");
                // return new HeroPower(new DealDamage(1, new Future()), "....", "Deal 1 damage.");
            case PALADIN:
                return new HeroPower(new SummonAction(1, 1, 1, "Silver Hand Recruit",
                        player, player, CardClass.PALADIN), "Reinforce", "Summon a 1/1 Silver Hand Recruit.");
                // return new HeroPower(new Summon(1, 1, 1, 1, "Silver Hand Recruit"), "....", "Summon a 1/1 Silver Hand Recruit.");
            case PRIEST:
                // return new HeroPower(new Heal(2, player, "Lesser Heal", "Restore 2 health.");
            case ROGUE:
                // return new HeroPower(new Equip(1, 2, player),
            case SHAMAN:
                // return new HeroPower(new SummonTotem(player), "...."  )
            case WARRIOR:
                // return new HeroPower(new Armor(2, player),
            case WARLOCK:
                // hpaction = new CompoundAction(new DealDamage(2, player), new DrawCard());
                // return new HeroPower(new DealDamageAndDrawCard(player),
            default:
                // return null; // literally can't
        }
        return null;
    }

    @Override
    public boolean playCard() {
        player.getGame().processEvent(new HeroPowerEvent(this));
        playable = false;
        this.action.execute(); // will process its own event
        return true;
    }

    public GameEvent createEvent(){
        return new HeroPowerEvent(this);
    }

    public class HeroPowerEvent implements GameEvent {

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
}
