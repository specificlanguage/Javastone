package org.specificlanguage.javastone.action;

import org.specificlanguage.javastone.entity.Entity;

public abstract class Targetable implements Action {

    public Entity caster;
    public Entity target;

    // future class for targetable actions, like dealing damage


    @Override
    public Entity getCaster() {
        return caster;
    }
}
