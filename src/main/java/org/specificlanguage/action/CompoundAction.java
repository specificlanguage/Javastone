package org.specificlanguage.action;

import java.util.Arrays;
import java.util.LinkedList;

public class CompoundAction implements Action{

    LinkedList<Action> actions;

    public CompoundAction(Action... actions){
        if(actions == null)
            throw new IllegalArgumentException();
        this.actions.addAll(Arrays.asList(actions));
    }

    @Override
    public boolean execute() {
        return false;
    }
}
