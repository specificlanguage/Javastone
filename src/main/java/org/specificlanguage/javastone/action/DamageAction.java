package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.entity.Entity;
import org.specificlanguage.javastone.entity.Future;
import org.specificlanguage.javastone.entity.Minion;
import org.specificlanguage.javastone.entity.Player;
import org.specificlanguage.javastone.event.GameEvent;
import org.specificlanguage.javastone.event.TargetableEvent;

import java.util.Random;

public class DamageAction implements Targetable {

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

    Entity target;
    Entity caster;
    int damage;

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
        caster.getGame().processEvent(createTargetableEvent());

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

    public Entity getTarget(){
        return target;
    }

    @Override
    public TargetableEvent createTargetableEvent() {
        return new TargetableEvent(this);
    }

    public GameEvent createEvent(){
        return new DamageEvent(this);
    }

    public int getDamage(){ return damage; }

    private boolean isMinion(Entity entity){
        if (entity instanceof Minion)
            return true;
        return false;
    }

    private boolean isPlayer(Entity entity){
        if(entity instanceof Player)
            return true;
        return false;
    }

}
