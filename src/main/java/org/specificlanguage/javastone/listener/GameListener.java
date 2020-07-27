package org.specificlanguage.javastone.listener;

import org.specificlanguage.javastone.action.Action;
import org.specificlanguage.javastone.event.GameEvent;

public class GameListener {

    GameEvent event;
    Action action; // TODO: make it so that actions are type-empty at start so we can change them at execution time

    GameListener(GameEvent event, Action action){
        this.event = event;
        this.action = action;
    }

    public boolean processEvent(GameEvent event) {
        if(checkAction(event.getAction())){
            action.execute(); //TODO, do you need to pass something in for processing events to check?
        }
        return true;
    }

    public GameEvent getEvent(){
        return event;
    }

    public boolean checkAction(Action action){
        return this.event.getAction().getClass() == action.getClass();
    }

    public Action getAction(){
        return action;
    }

}
