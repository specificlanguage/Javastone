package org.specificlanguage.javastone.listener;

import org.specificlanguage.javastone.action.GameAction;
import org.specificlanguage.javastone.event.GameEvent;

public class GameListener {

    GameEvent event;
    GameAction actionToListen; // TODO: make it so that actions are type-empty at start so we can change them at execution time
    GameAction actionToRemove;

    GameListener(GameEvent event, GameAction actionToListen, GameAction actionToRemove){
        this.event = event;
        this.actionToListen = actionToListen;
        this.actionToRemove = actionToRemove;
    }

    public boolean processEvent(GameAction action){
        if (action.getClass() == this.actionToListen.getClass()){
            action.execute();
            return true;
        }
        return false;
    }

    public GameEvent getEvent(){
        return event;
    }

    public boolean checkAction(GameAction action){
        return this.actionToListen.getClass() == action.getClass();
    }

    public GameAction getAction(){
        return actionToListen;
    }

    public GameAction getActionToRemove(){
        return actionToRemove;
    }

    public boolean checkToRemove(GameAction action){
        return this.actionToListen.equals(action);
    }

}
