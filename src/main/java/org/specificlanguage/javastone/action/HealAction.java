package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.entity.Entity;
import org.specificlanguage.javastone.event.GameEvent;

public class HealAction implements Action {

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
        if(this.target.health != this.target.maxHealth) {
            caster.getGame().processEvent(createEvent());
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
}
