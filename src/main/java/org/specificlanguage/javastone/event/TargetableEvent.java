package org.specificlanguage.javastone.event;

import org.specificlanguage.javastone.action.Action;
import org.specificlanguage.javastone.action.Targetable;

public class TargetableEvent implements GameEvent {

    Targetable targetable;

    public TargetableEvent(Targetable targetable){
        this.targetable = targetable;
    }

    @Override
    public Action getAction() {
        return targetable;
    }
}
