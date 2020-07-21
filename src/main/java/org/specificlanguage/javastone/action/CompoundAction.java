package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.entity.Entity;

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
}
