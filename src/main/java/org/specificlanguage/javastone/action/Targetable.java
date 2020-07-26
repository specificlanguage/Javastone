package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.entity.Entity;
import org.specificlanguage.javastone.event.GameEvent;
import org.specificlanguage.javastone.event.TargetableEvent;

public interface Targetable extends Action{

    Entity getTarget();

    TargetableEvent createTargetableEvent();

}
