package org.specificlanguage.javastone.card;

import org.specificlanguage.javastone.HSGame;
import org.specificlanguage.javastone.action.GameAction;
import org.specificlanguage.javastone.entity.Entity;

public class SpellCard extends Card{

    GameAction action;
    Entity caster;
    HSGame game;

    /**
     * SpellCard - custom entry
     * @param caster Entity that casts the object
     * @param action Action that the card does when executed
     * @param mana Cost
     * @param name Name of the spell
     * @param cardClass Class of the spell
     */

    public SpellCard(Entity caster, GameAction action, int mana, String name, CardClass cardClass){
        if(action.getCaster() != caster){
            throw new IllegalArgumentException();
        } else if (mana < 0){
            throw new IllegalArgumentException();
        }

        this.action = action;
        this.caster = caster;
        this.game = caster.getGame();
        this.mana = mana;
        this.name = name;
        this.cardClass = cardClass;
        this.playerControlled = caster.getPlayerControlled();
    }


    /**
     * SpellCard - DBF entry
     * @param caster Entity that casts the object
     * @param dbf DBF ID of the spell to lookup
     */
    public SpellCard(Entity caster, int dbf){
        this.caster = caster;
        this.dbf = dbf;
        this.game = caster.getGame();
        // Lookup Card
        // call ActionBuilder for all effects
    }

    /**
     * SpellCard - Hearthstone Card ID entry
     * @param caster Entity that casts the object
     * @param cardID Hearthstone Card ID of the spell to lookup
     */

    public SpellCard(Entity caster, String cardID){
        this.caster = caster;
        this.id = cardID;
        this.game = caster.getGame();
        // Lookup Card
        // call ActionBuilder for all effects
    }

    GameAction getAction(){
        return action;
    }

/*
    @Override
    boolean playCard() {
        game.processEvent(new SpellCastEvent(this));
        action.execute();
        return true;
    }

 */

    @Override
    boolean playCard() {
        // temp
        return false;
    }

    @Override
    boolean isPlayable() {
        return false;
    }
}
