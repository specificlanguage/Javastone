package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.HSGame;
import org.specificlanguage.javastone.entity.Entity;
import org.specificlanguage.javastone.event.GameEvent;

public class AttackAction extends Targetable {

    HSGame game;

    public AttackAction(Entity caster, Entity target){
        this.caster = caster;
        this.target = target;
        this.game = caster.getGame();
    }

    @Override
    public boolean execute() {
        return true; // TODO attack
    }

    @Override
    public GameEvent createEvent() {
        return null;
    }

    public boolean canAttack(){
        return true; // TODO check
    }
}
