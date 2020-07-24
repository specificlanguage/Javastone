package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.entity.Entity;
import org.specificlanguage.javastone.entity.Future;
import org.specificlanguage.javastone.entity.Player;
import org.specificlanguage.javastone.event.GameEvent;

import java.util.Random;

public class DamageAction extends Targetable {

    private class DamageEvent implements GameEvent {

        public DamageAction damage;
        public DamageEvent(DamageAction damage){
            this.damage = damage;
        }
        @Override
        public Action getAction() {
            return damage;
        }
    }

    private int damage;

    public DamageAction(Entity caster, Entity target, int damage){
        if(caster instanceof Future || target == null || caster == null || damage <= 0){
            throw new IllegalArgumentException();
        }
        this.target = target;
        this.caster = caster;
        this.damage = damage;
    }


    @Override
    public boolean execute() {

        caster.getGame().processEvent(createEvent());

        if(target instanceof Future){
            if(caster instanceof Player){
                //TODO let them pick the target
            } else {
                //TODO pick random target
            }
        }
        target.damage(damage);
        return true;
    }

    public Entity getCaster(){
        return caster;
    }

    public GameEvent createEvent(){
        return new DamageEvent(this);
    }

}
