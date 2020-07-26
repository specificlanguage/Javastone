package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.entity.Entity;
import org.specificlanguage.javastone.event.GameEvent;

import java.util.Arrays;
import java.util.List;

public class CompoundAction implements Action {

    private class CompoundEvent implements GameEvent{

        public CompoundAction action;

        public CompoundEvent(CompoundAction action){
            this.action = action;
        }

        @Override
        public Action getAction() {
            return action;
        }
    }

    List<Action> actions;
    Entity caster;

    public CompoundAction(){}

    public CompoundAction(Entity caster, Action... actions){
        if(actions == null || caster == null)
            throw new IllegalArgumentException();
        this.caster = caster;
        this.actions = Arrays.asList(actions);
    }

    public void setCaster(Entity caster){
        this.caster = caster;
    }

    public void addAction(Action action){
        actions.add(action);
    }

    @Override
    public boolean execute() {
        for(Action action : actions){
            caster.getGame().processEvent(action.createEvent());
            action.execute();
        }
        return true;
    }
    public GameEvent createEvent() {
        return new CompoundEvent(this);
    }
    public List<Action> getActions(){
        return actions;
    }
    public Entity getCaster(){ return caster; }
}
