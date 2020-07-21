package org.specificlanguage.javastone.event;

import org.specificlanguage.javastone.action.Action;
import org.specificlanguage.javastone.action.DamageAction;

public class DamageEvent implements GameEvent {

    public DamageAction damage;

    public DamageEvent(DamageAction damage){
        this.damage = damage;
    }

    @Override
    public Action getAction() {
        return damage;
    }
}
