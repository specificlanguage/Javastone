package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.entity.Entity;

import java.util.Arrays;
import java.util.LinkedList;

public class CompoundAction implements Action{

    LinkedList<Action> actions;
    Entity caster;

    public CompoundAction(Entity caster, Action... actions){
        if(actions == null || caster == null)
            throw new IllegalArgumentException();
        this.caster = caster;
        this.actions.addAll(Arrays.asList(actions));
    }

    @Override
    public boolean execute() {
        return false;
    }
}
