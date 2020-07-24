package org.specificlanguage.javastone.event;

import org.specificlanguage.javastone.action.Action;
import org.specificlanguage.javastone.entity.Player;

public class StartOfTurnEvent implements GameEvent{

    // dummy event for executing action

    Player player;

    StartOfTurnEvent(Player player){
        this.player = player;
    }

    @Override
    public Action getAction() {
        return null;
    }

}
