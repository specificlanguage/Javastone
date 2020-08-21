package org.specificlanguage.javastone.listener;

import org.specificlanguage.javastone.action.ActionArg;
import org.specificlanguage.javastone.action.GameAction;

public class GameListener {

    GameAction actionToListen; // TODO: make it so that actions are type-empty at start so we can change them at execution time
    GameAction actionToDo;
    GameAction actionToRemove;

    public GameListener(GameAction actionToListen, GameAction actionToDo){
        this(actionToListen, actionToDo, actionToListen);
    }

    public GameListener(GameAction actionToListen, GameAction actionToDo, GameAction actionToRemove){
        this.actionToListen = actionToListen;
        this.actionToDo = actionToDo;
        this.actionToRemove = actionToRemove;
    }

    public boolean processEvent(GameAction action, ActionArg... args){
        if (GameAction.checkCriteria(action, actionToListen, args)){
            actionToDo.cast();
            if(checkToRemove(action)){
                action.getCaster().getGame().removeListener(this);
            }
            return true;
        }

        return false;
    }

    public boolean checkAction(GameAction action){
        return this.actionToListen.getClass() == action.getClass();
    }

    public GameAction getActionToListen(){
        return actionToListen;
    }

    public GameAction getActionToDo(){
        return actionToDo;
    }

    public GameAction getActionToRemove(){
        return actionToRemove;
    }

    public boolean checkToRemove(GameAction action){
        return this.actionToListen.equals(action);
    }

}
