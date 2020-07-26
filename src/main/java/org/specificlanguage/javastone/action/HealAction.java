package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.entity.Entity;
import org.specificlanguage.javastone.event.GameEvent;
import org.specificlanguage.javastone.event.TargetableEvent;

public class HealAction implements Targetable {

    private class HealEvent implements GameEvent{

        HealAction action;
        HealEvent(HealAction action){this.action = action;}

        @Override
        public Action getAction() {
            return null;
        }
    }

    Entity caster;
    Entity target;
    int health;

    public HealAction(Entity caster, Entity target, int health){
        this.caster = caster;
        this.target = target;
        this.health = health;
    }


    /**
     * This execute is different as they have to check if the target has actually been healed or not, so therefore,
     * the processEvent call comes after the healing to really check if they've actually been healed.
     */
    @Override
    public boolean execute() {
        if(this.target.getHealth() != this.target.getMaxHealth()) {
            caster.getGame().processEvent(createEvent());
            caster.getGame().processEvent(createTargetableEvent());
        }
        caster.heal(health);
        return true;
    }

    @Override
    public GameEvent createEvent() {
        return new HealEvent(this);
    }

    @Override
    public Entity getCaster() {
        return caster;
    }

    @Override
    public Entity getTarget() {
        return target;
    }

    @Override
    public TargetableEvent createTargetableEvent() {
        return new TargetableEvent(this);
    }

    public int getHealth(){ return health; }
}
