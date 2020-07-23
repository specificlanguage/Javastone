package org.specificlanguage.javastone.listener;

import org.specificlanguage.javastone.action.Action;
import org.specificlanguage.javastone.event.GameEvent;

public interface GameListener {

    boolean processEvent(Action action);
    GameEvent getEvent(); // get property of event
    boolean getPersistent();
    boolean checkAction(Action action);

    //TODO: every process event needs to at least push itself, then pop itself

}
