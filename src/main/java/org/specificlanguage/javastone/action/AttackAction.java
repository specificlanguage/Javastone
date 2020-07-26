package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.HSGame;
import org.specificlanguage.javastone.entity.Entity;
import org.specificlanguage.javastone.entity.Future;
import org.specificlanguage.javastone.entity.Minion;
import org.specificlanguage.javastone.entity.Player;
import org.specificlanguage.javastone.entity.attributes.Attribute;
import org.specificlanguage.javastone.event.GameEvent;
import org.specificlanguage.javastone.event.TargetableEvent;

public class AttackAction implements Targetable {

    private class AttackEvent implements GameEvent{

        AttackAction action;
        AttackEvent(AttackAction action){ this.action = action; }

        @Override
        public Action getAction() {
            return action;
        }
    }

    private class AfterAttackEvent implements GameEvent{
        AttackAction action;
        AfterAttackEvent(AttackAction action){
            this.action = action;
        }

        @Override
        public Action getAction(){
            return action;
        }
    }

    Entity caster;
    Entity target;

    public AttackAction(Entity caster, Entity target){
        this.caster = caster;
        this.target = target;
    }

    @Override
    public boolean execute() {

        // Attack checks
        HSGame game = caster.getGame();
        assert game.isInGame(caster);
        assert game.isInGame(target);
        if(!caster.canAttack()) {
            // send message to player that you can't attack
            return false;
        } else if (caster == target){
            throw new IllegalArgumentException();
        } else if (caster instanceof Future){
            return false;
        } else if (target instanceof Future){
            // TODO: set target to one's selection
        } if (target instanceof Minion && game.getBoard().tauntOnBoard(target.getPlayerControlled()) &&
            !((Minion) target).hasTaunt()){
            // send message to player that it can't attack
            return false;
        } else if (target.getAttributes().contains(Attribute.STEALTH)){
            // send message to player that it can't attack it
            return false;
        } else if (caster.getAttributes().contains(Attribute.RUSH) && target instanceof Player){
            // send message to player
            return false;
        } else if (caster.getAttributes().contains(Attribute.CANT_ATTACK_HEROES) && target instanceof Player) {
            // send message to player that you can't attack
            return false;
        }

        // AttackEvent is processed
        game.processEvent(createEvent());
        deathCheck();

        // Attacks
        if(target instanceof Minion){
            target.damage(caster.getAttack());
            caster.damage(target.getAttack());
        } else {
            target.damage(caster.getAttack());
        }

        deathCheck();
        game.processEvent(new AfterAttackEvent(this));

        return true;
    }

    @Override
    public GameEvent createEvent() {
        return new AttackEvent(this);
    }

    private void deathCheck(){
        if(target.isDead()){
            target.onDeath();
        } else if (caster.isDead()) {
            caster.onDeath();
        }
    }

    @Override
    public Entity getTarget(){
        return target;
    }

    @Override
    public TargetableEvent createTargetableEvent() {
        return new TargetableEvent(this);
    }

    @Override
    public Entity getCaster(){
        return caster;
    }
}
