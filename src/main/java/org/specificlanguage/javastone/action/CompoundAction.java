package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.entity.Entity;
import org.specificlanguage.javastone.event.GameEvent;

import java.util.Arrays;
import java.util.List;

public class CompoundAction implements Action {

    List<Action> actions;
    Entity caster;

    public CompoundAction(Entity caster, Action... actions){
        if(actions == null || caster == null)
            throw new IllegalArgumentException();
        this.caster = caster;
        this.actions = Arrays.asList(actions);
    }

    @Override
    public boolean execute() {
        for(Action action : actions){
            action.execute();
        }
        return true;
    }

    @Override
    public GameEvent createEvent() {
        // TODO return new CompoundEvent that deals with all events here
        return null;
    }

    public List<Action> getActions(){
        return actions;
    }
}
