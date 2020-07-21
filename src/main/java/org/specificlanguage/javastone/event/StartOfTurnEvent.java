package org.specificlanguage.javastone.event;

import org.specificlanguage.javastone.action.Action;

public class StartOfTurnEvent implements GameEvent{

    // dummy event for executing action

    @Override
    public Action getAction() {
        return null;
    }

}
