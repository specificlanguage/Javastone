package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.entity.Entity;
import org.specificlanguage.javastone.entity.Minion;
import org.specificlanguage.javastone.event.GameEvent;

public class DeathAction implements Action {

    private class DeathEvent implements GameEvent{

        DeathAction action;
        DeathEvent(DeathAction action){ this.action = action; }

        @Override
        public Action getAction() {
            return action;
        }
    }

    Entity entity;

    public DeathAction(Entity entity){
        this.entity = entity;
    }

    @Override
    public boolean execute() {
        entity.getGame().processEvent(createEvent());
        return true;
    }

    @Override
    public GameEvent createEvent() {
        return new DeathEvent(this);
    }

    @Override
    public Entity getCaster() {
        return entity;
    }


}
