package org.specificlanguage.javastone.action.test;

import org.specificlanguage.javastone.entity.Entity;
import org.specificlanguage.javastone.entity.Minion;
import org.specificlanguage.javastone.event.GameEvent;

import java.util.HashMap;

public interface GameAction<T> {

    boolean execute(T t);
    // GameEvent<T> createEvent(GameEvent<T>);
    Entity getCaster();
    Command getGameAction();

}
