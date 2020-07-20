package org.specificlanguage.event;

import org.specificlanguage.card.HeroPower;

import java.awt.*;
import java.util.Objects;

public class HeroPowerEvent implements Event {

    private final HeroPower hp;

    public HeroPowerEvent(HeroPower hp) {
        this.hp = Objects.requireNonNull(hp);
    }

    public HeroPower getHeroPower(){
        return this.hp;
    }


}
