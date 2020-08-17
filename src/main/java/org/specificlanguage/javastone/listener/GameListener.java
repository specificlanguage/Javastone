package org.specificlanguage.javastone.listener;

import org.specificlanguage.javastone.action.GameAction;

public class GameListener {

    GameAction actionToListen; // TODO: make it so that actions are type-empty at start so we can change them at execution time
    GameAction actionToRemove;

    GameListener(GameAction actionToListen, GameAction actionToRemove){
        this.actionToListen = actionToListen;
        this.actionToRemove = actionToRemove;
    }

    public boolean processEvent(GameAction action){
        if (action.getClass() == this.actionToListen.getClass()){
            action.cast();
            return true;
        }
        return false;
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
