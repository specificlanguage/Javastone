package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.entity.Entity;

public interface GameAction {

    boolean cast();
    Entity getCaster();
    Entity getTarget();
    ActionInfo getInfo();

}
