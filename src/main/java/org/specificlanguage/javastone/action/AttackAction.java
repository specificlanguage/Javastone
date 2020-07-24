package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.HSGame;
import org.specificlanguage.javastone.entity.Entity;
import org.specificlanguage.javastone.entity.Future;
import org.specificlanguage.javastone.entity.Minion;
import org.specificlanguage.javastone.entity.Player;
import org.specificlanguage.javastone.entity.attributes.Attribute;
import org.specificlanguage.javastone.event.GameEvent;
import org.w3c.dom.Attr;

public class AttackAction extends Targetable {

    private class AttackEvent implements GameEvent{

        AttackAction action;
        AttackEvent(AttackAction action){ this.action = action; }

        @Override
        public Action getAction() {
            return action;
        }
    }

    HSGame game;

    public AttackAction(Entity caster, Entity target){
        this.caster = caster;
        this.target = target;
        this.game = caster.getGame();
    }

    @Override
    public boolean execute() {
        if(!caster.canAttack()) {
            // send message to player that you can't attack
            return false;
        } else if (caster instanceof Future){
            return false;
        } else if (target instanceof Future){
            // TODO: set target to one's selection
        } if (target instanceof Minion && game.getBoard().tauntOnBoard(target.getPlayerControlled()) &&
            !((Minion) target).hasTaunt()){
            // send message to player that you can't attack
            return false;
        } else if (target.attributes.contains(Attribute.STEALTH)){
            // send message to player that you can't attack
            return false;
        } else if (caster.attributes.contains(Attribute.RUSH) && target instanceof Player){
            // send message to player
            return false;
        } else if (caster.attributes.contains(Attribute.CANT_ATTACK_HEROES) && target instanceof Player) {
            // send message to player that you can't attack
            return false;
        }

        game.processEvent(createEvent());
        if(caster == target){
            // send message to player that you can't attack yourself (unless overridden by another way, somehow?)
            throw new IllegalArgumentException();
        }
        if(target instanceof Minion){
            if(caster.isDead()){
                new DeathAction(caster).execute();
                return true;
            } else if(target.isDead()){
                new DeathAction(target).execute();
                return true;
            } if(game.getBoard().isOnBoard((Minion) target)){
                caster.attack(target);
                if(target.isDead()){
                    target.onDeath();
                } else if (caster.isDead()){
                    caster.onDeath();
                }
            }
        }
        return true;
    }

    @Override
    public GameEvent createEvent() {
        return new AttackEvent(this);
    }
}
