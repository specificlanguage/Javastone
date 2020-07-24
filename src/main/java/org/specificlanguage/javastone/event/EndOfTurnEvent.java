package org.specificlanguage.javastone.event;

import org.specificlanguage.javastone.action.Action;
import org.specificlanguage.javastone.entity.Player;

public class EndOfTurnEvent implements GameEvent {

    Player player;

    EndOfTurnEvent(Player player){
        this.player = player;
    }

    @Override
    public Action getAction() {
        return null;
    }
}
