package org.specificlanguage.javastone.listener;

import org.specificlanguage.javastone.event.GameEvent;

public interface GameListener {

    boolean processEvent();
    GameEvent getEvent(); // get property of event

}
