package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.HSGame;
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
            caster.getGame().processEvent(action.createEvent());
            action.execute();
        }
        return true;
    }

    /**
     * createEvent() is different in CompoundActions as CompoundEvents do not exist. Instead, each event in its action queue
     * are created, processed and then returned null.
     * @return null, as CompoundEvents aren't registered as events in the game. Each event is created and then processed.
     */
    public GameEvent createEvent() {
        return null; //CompoundActions are just internal actions that have two things
    }
    public List<Action> getActions(){
        return actions;
    }
    public Entity getCaster(){ return caster; }
}
