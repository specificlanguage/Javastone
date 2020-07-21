package org.specificlanguage.javastone.event;

import org.specificlanguage.javastone.action.Action;
import org.specificlanguage.javastone.card.HeroPower;

import java.util.Objects;

public class HeroPowerEvent implements GameEvent {

    private final HeroPower hp;

    public HeroPowerEvent(HeroPower hp) {
        this.hp = Objects.requireNonNull(hp);
    }

    public HeroPower getHeroPower(){
        return this.hp;
    }

    public Action getAction(){
        return hp.action;
    }

}
