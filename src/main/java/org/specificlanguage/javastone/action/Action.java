package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.entity.Entity;
import org.specificlanguage.javastone.entity.Player;
import org.specificlanguage.javastone.event.GameEvent;

public interface Action {

    boolean execute();
    GameEvent createEvent();
    Entity getCaster();

}
